package com.saiful.graph;

import org.junit.jupiter.api.Test;

import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

class GraphTravesalTest {


    @Test
    void testComputePath() {
        Graph graph = new Graph();

        graph.addEdge(new Vertex("A"), new Vertex("B"), 5, "a-b");
        graph.addEdge(new Vertex("A"), new Vertex("C"), 10, "a-c");
        graph.addEdge(new Vertex("B"), new Vertex("D"), 3, "b-d");
        graph.addEdge(new Vertex("C"), new Vertex("E"), 4, "c-e");
        graph.addEdge(new Vertex("D"), new Vertex("E"), 2, "d-e");
        graph.addEdge(new Vertex("D"), new Vertex("F"), 4, "d-f");



        GraphTraversal graphTraversal = new GraphTraversal(graph);
        Map<String, Integer> result = graphTraversal.computePath(new Vertex("A"));
        System.out.println(result);
        assertEquals(5, result.get("B"));
        assertEquals(8, result.get("D"));
        assertEquals(10, result.get("E"));
        assertEquals(12, result.get("F"));

    }


}