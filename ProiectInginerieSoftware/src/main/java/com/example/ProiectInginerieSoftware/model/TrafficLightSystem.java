package com.example.ProiectInginerieSoftware.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrafficLightSystem {

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
}