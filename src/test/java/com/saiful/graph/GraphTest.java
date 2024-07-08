package com.saiful.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    Graph graph;

    @BeforeEach
    public void setup() {
        graph = new Graph();
        graph.addEdge(new Vertex("A"), new Vertex("B"),2, "a-b");
        graph.addEdge(new Vertex("A"), new Vertex("C"),1, "a-c");
    }

    @Test
    void testGetNeighbours(){
        Map<Vertex, Edge> result = graph.getEdges(new Vertex("A"));

        assertEquals(2, result.size());
        assertEquals(2,result.get( new Vertex("B")).getWeight());
    }

    @Test
    void testEdgesVertices() {
        graph = new Graph();
        graph.addEdge(new Vertex("A"), new Vertex("B"), 2, "a-b");
        graph.addEdge(new Vertex("A"), new Vertex("C"), 2, "a-C");
        Map<Vertex, Edge> result = graph.getEdges(new Vertex("A"));
        assertEquals(2, result.size());
        assertEquals(2,result.get( new Vertex("B")).getWeight());
    }

    @Test
    public void testDisplay() {
        graph.display();
    }

}