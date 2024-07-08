package com.saiful.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<Vertex, HashMap<Vertex, Integer>> adjVertices;
    private Map<Vertex, HashMap<Vertex, Edge>> adjEdgeVertices;

    public Graph(){
        adjVertices = new HashMap<>();
        adjEdgeVertices = new HashMap<>();
    }

    public void addEdge(Vertex parent, Vertex child, int weight, String edgeName){
        if(weight < 0)
            throw new IllegalArgumentException("distance cannot < 0");
        Edge edge = new Edge();
        edge.setName(edgeName);
        edge.setWeight(weight);

        adjEdgeVertices.putIfAbsent(parent, new HashMap<>());
        adjEdgeVertices.get(parent).putIfAbsent(child, edge);
        adjEdgeVertices.putIfAbsent(child, new HashMap<>());
        adjEdgeVertices.get(child).put(parent, edge);

    }

    public Map<Vertex, Integer> getNeighbours(Vertex vertex){
        return adjVertices.getOrDefault(vertex, new HashMap<>());
    }

    public Map<Vertex, Edge> getEdges(Vertex vertex){
        return adjEdgeVertices.getOrDefault(vertex, new HashMap<>());
    }

    public Map<Vertex, HashMap<Vertex, Integer>> getAdjVertices() {
        return adjVertices;
    }

    public Map<Vertex, HashMap<Vertex, Edge>> getAdjEdgeVertices() {
        return adjEdgeVertices;
    }

    public void display() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Vertex, HashMap<Vertex, Edge>> map : adjEdgeVertices.entrySet()) {
            builder.append(map.getKey().getName()).append(":");

            for (Map.Entry<Vertex, Edge> child: map.getValue().entrySet()){
                builder.append(child.getKey().getName()).append("(").append(child.getValue().getName()).append(")");
                builder.append("[").append(child.getValue().getWeight()).append("]");
                builder.append("--");
            }
            builder.append("\n");

        }
        System.out.println(builder);
    }
}
