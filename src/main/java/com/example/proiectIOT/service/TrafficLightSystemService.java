package com.example.proiectIOT.service;

import com.example.proiectIOT.model.TrafficLightSystem;
import com.example.proiectIOT.repository.TrafficLightSystemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Service
public class TrafficLightSystemService {

    private final TrafficLightSystemRepository trafficLightSystemRepository;



    void DFS(int vertex, int stop, TrafficLightSystem trafficLightSystem)
    {
        List<Boolean> visited = trafficLightSystem.getVisited();
        visited.set(vertex,true);

        int i = trafficLightSystem.getIntersections()+1;
        trafficLightSystem.setIntersections(i);

        List<Integer> route = trafficLightSystem.getRoute();
        LinkedList<Integer>[] streets = trafficLightSystem.getStreets();



        if (vertex == stop)
        {
            System.out.print("Ruta calculata: ");
            for (int j = 0; j < i; j++)
                System.out.print(route.get(j) + " ");
            System.out.println();
        }

        for (int adj : streets[vertex])
        {
            if (!visited.get(adj))
                DFS(adj, stop, trafficLightSystem);
        }
    }

    public List<TrafficLightSystem> getAllSystems() {
        return trafficLightSystemRepository.findAll();
    }
    public void insertSystem(TrafficLightSystem trafficLightSystem) {
        System.out.println("Inserting traffic light system " + trafficLightSystem);
        trafficLightSystemRepository.insert(trafficLightSystem);
    }

    public void updateSystem(TrafficLightSystem trafficLightSystem) {
        TrafficLightSystem savedSystem = trafficLightSystemRepository.findById(trafficLightSystem.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find System by ID %s", trafficLightSystem.getId())));
        savedSystem.setRoute(trafficLightSystem.getRoute());
    }

    public Object getSystem(String id) {
        return trafficLightSystemRepository.findTrafficLightSystemById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find System with ID - %s", id)));
    }

    public void deleteSystem(String id) {
        trafficLightSystemRepository.deleteById(id);
    }
}
