package com.example.ProiectInginerieSoftware.mqtt;

import com.example.ProiectInginerieSoftware.model.Ambulance;
import com.example.ProiectInginerieSoftware.model.TrafficLightSystem;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MqttBeans {

    public MqttPahoClientFactory mqttClientFactory(){
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();

        options.setServerURIs(new String[]{"tcp://localhost:1883"});
        options.setUserName("admin");
        String pass = "123456789";
        options.setPassword(pass.toCharArray());
        options.setCleanSession(true);

        factory.setConnectionOptions(options);

        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound(){
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("serverIn", mqttClientFactory(), "#");

        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler(){
        return new MessageHandler() {
            private RestTemplate restTemplate;

            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
                System.out.println(message.getPayload() + " written to topic: " + topic );


                if(topic.equals("ambulance")){


                    HttpHeaders headers = new HttpHeaders();
                    // set `content-type` header
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    // set `accept` header
                    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

                    String[] fields = message.getPayload().toString().split(",");
                    String url = "https://localhost:8081/emergency/"+fields[6];
                    // create a map for post parameters
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", fields[0]);
                    map.put("licensePlate", fields[1]);
                    map.put("sensorStatus", fields[2]);
                    map.put("mfcc1", fields[3]);
                    map.put("mfcc2",fields[4]);
                    map.put("mfcc3",fields[5]);

                    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

                    ResponseEntity<Ambulance> response = this.restTemplate.postForEntity(url, entity, Ambulance.class);

                }

                if(topic.equals("trafficLight")){
                    HttpHeaders headers = new HttpHeaders();
                    // set `content-type` header
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    // set `accept` header
                    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

                    String[] fields = message.getPayload().toString().split(";");
                    String url = "https://localhost:8081/trafficLight/";
                    // create a map for post parameters
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", fields[0]);
                    map.put("streets", fields[1]);
                    map.put("visited", fields[2]);
                    map.put("route",fields[3]);
                    map.put("intersections",fields[4]);

                    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

                    ResponseEntity<TrafficLightSystem> response = this.restTemplate.postForEntity(url, entity, TrafficLightSystem.class);

                }

            }
        };
    }

    @Bean
    public MessageChannel mqttOutboundChannel(){
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound(){
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("serverOut", mqttClientFactory());

        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("#");
        return messageHandler;
    }



}
