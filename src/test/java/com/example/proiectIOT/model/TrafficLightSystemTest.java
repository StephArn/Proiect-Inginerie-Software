package com.example.proiectIOT.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class TrafficLightSystemTest {

//    private final LinkedList<Integer>[] streets;
//
//    TrafficLightSystemTest(LinkedList<Integer>[] streets) {
//        this.streets = streets;
//    }


//    @Test
//    void addEdgeTest() {
//        streets[1];
//
//    }

//    @Test
//    void DFS() {
//    }

    @Test
    void getId() {
    }

    @Test
    public void testConstructor() {
        LinkedList<Integer> integerList = new LinkedList<Integer>();
        LinkedList<Integer> integerList1 = new LinkedList<Integer>();
        LinkedList<Integer>[] linkedListArray = new LinkedList[]{integerList, integerList1, new LinkedList<Integer>()};
        ArrayList<Boolean> resultBooleanList = new ArrayList<Boolean>();
        ArrayList<Integer> integerList2 = new ArrayList<Integer>();
        TrafficLightSystem actualTrafficLightSystem = new TrafficLightSystem(linkedListArray, resultBooleanList,
                integerList2);

        assertNull(actualTrafficLightSystem.getId());
        assertEquals("TrafficLightSystem(id=null, streets=[[], [], []], visited=[], route=[], intersections=0)",
                actualTrafficLightSystem.toString());
        List<Boolean> visited = actualTrafficLightSystem.getVisited();
        assertSame(resultBooleanList, visited);
        assertEquals(integerList2, visited);
        assertTrue(visited.isEmpty());
        LinkedList<Integer>[] streets = actualTrafficLightSystem.getStreets();
        assertEquals(3, streets.length);
        List<Integer> route = actualTrafficLightSystem.getRoute();
        assertEquals(visited, route);
        assertEquals(integerList2, route);
        assertTrue(route.isEmpty());
        assertEquals(0, actualTrafficLightSystem.getIntersections());
        assertSame(streets, linkedListArray);
        assertSame(visited, resultBooleanList);
        assertEquals(route, integerList2);
        assertEquals(visited, integerList2);
        assertTrue(integerList2.isEmpty());
    }

    @Test
    public void testConstructor2() {
        TrafficLightSystem actualTrafficLightSystem = new TrafficLightSystem(1);
        assertTrue(actualTrafficLightSystem.getVisited().isEmpty());
        assertEquals(1, actualTrafficLightSystem.getStreets().length);
    }

    @Test
    public void testConstructor3() {
        assertThrows(NegativeArraySizeException.class, () -> new TrafficLightSystem(-1));
    }

    @Test
    void getStreets() {
    }

    @Test
    void getVisited() {
    }

    @Test
    void getRoute() {
    }

    @Test
    void getIntersections() {
    }

    @Test
    void setId() {
    }

    @Test
    void setRoute() {
    }

    @Test
    void setIntersections() {
    }
}