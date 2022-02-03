package com.example.proiectIOT.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Data
@Document
public class TrafficLightSystem {
    @Id
    private String id;
    private final LinkedList<Integer>[] streets;
    private final List<Boolean> visited;
    private List<Integer> route;
    private int intersections;// = 0;

    public TrafficLightSystem(LinkedList<Integer>[] streets, List<Boolean> visited, List<Integer> route) {
        this.streets = streets;
        this.visited = visited;
        this.route = new ArrayList();
        this.intersections = 0;
    }

    public TrafficLightSystem(int vertices)
    {
        streets = new LinkedList[vertices];
        visited = new ArrayList<Boolean>();

        for (int i = 0; i < vertices; i++)
            streets[i] = new LinkedList<Integer>();
    }

    public void addEdge(int src, int dest)
    {
        streets[src].add(dest);
    }

    public void DFS1(int vertex, int stop)
    {
        visited.set(vertex, true);
        route.set(intersections++, vertex);

        if (vertex == stop)
        {
            System.out.print("Ruta calculata: ");
            for (int j = 0; j < intersections; j++)
                System.out.print(route.get(j) + " ");
            System.out.println();
        }


        for (int adj : streets[vertex])
        {
            if (!visited.get(adj))
                DFS1(adj, stop);
        }
    }
    public List<Integer> DFS(){
        List<Integer> route = new ArrayList<Integer>();
        Random rand = new Random();
        route.add(0);
        int adress = rand.nextInt(11) + 1;
        route.add(adress);
        adress = rand.nextInt(11) + 1;
        route.add(adress);
        adress = rand.nextInt(11) + 1;
        route.add(adress);
        adress = rand.nextInt(11) + 1;
        route.add(adress);
        return route;

    }
}
