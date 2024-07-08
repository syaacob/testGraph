package com.saiful.graph;

import java.util.*;

public class GraphTraversal {
    private Graph graph;
    private Map<String, String> previousNode = new HashMap<>();

    public GraphTraversal(Graph graph){
        this.graph = graph;
    }

    public Map<String, Integer> compute(Vertex startVertex) {
        String start = startVertex.getName();

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Map<String, Integer> distances = new HashMap<>();

        for(Vertex node: graph.getAdjVertices().keySet()){
            distances.put(node.getName(), Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()){
            Node current = priorityQueue.poll();
            String currentNode = current.getName();

            for(Map.Entry<Vertex, Integer> connections: graph.getNeighbours(new Vertex(currentNode)).entrySet()){
                String connection = connections.getKey().getName();
                int weight = connections.getValue();
                int newDistance = distances.get(currentNode) + weight;

                if(newDistance < distances.getOrDefault(connection, Integer.MAX_VALUE)){
                    distances.put(connection, newDistance);
                    previousNode.put(connection, currentNode);
                    priorityQueue.add(new Node(connection, newDistance));

                }

            }
        }

        return distances;
    }

    public Map<String, Integer> computePath(Vertex startVertex) {
        String start = startVertex.getName();

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Map<String, Integer> distances = new HashMap<>();

        for(Vertex node: graph.getAdjEdgeVertices().keySet()){
            distances.put(node.getName(), Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()){
            Node current = priorityQueue.poll();
            String currentNode = current.getName();

            for(Map.Entry<Vertex, Edge> connections: graph.getEdges(new Vertex(currentNode)).entrySet()){
                String connection = connections.getKey().getName();
                int weight = connections.getValue().getWeight();
                int newDistance = distances.get(currentNode) + weight;

                if(newDistance < distances.getOrDefault(connection, Integer.MAX_VALUE)){
                    distances.put(connection, newDistance);
                    previousNode.put(connection, currentNode);
                    priorityQueue.add(new Node(connection, newDistance));

                }

            }
        }

        return distances;
    }

    public Map<String, String> getPreviousNode() {
        return previousNode;
    }

    public List<String> getShortestPath(Map<String, String> previousNode, Vertex start, Vertex end) {
        List<String> path = new ArrayList<>();
        for(String at = end.getName(); at != null; at=previousNode.get(at)){
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
