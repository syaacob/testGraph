package com.saiful;

import com.saiful.graph.Graph;
import com.saiful.graph.GraphTraversal;
import com.saiful.graph.Vertex;
import com.saiful.input.From;
import com.saiful.input.JSonInput;
import com.saiful.input.Package;
import com.saiful.input.To;
import com.saiful.input.Train;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String path = args[0];
        System.out.println(path);
        JSonInput jSonInput = new JSonInput();
        List<From> inputs = jSonInput.readInput(path + "/graph.json");
        List<Train> trains = jSonInput.readTrainInput(path + "/train.json");
        List<Package> packageList = jSonInput.readPackageInput(path + "/package.json");


        Graph graph = new Graph();
        for (From input: inputs){
            Vertex parent = new Vertex(input.getFrom());
            for (To to: input.getTo()) {
                Vertex child = new Vertex(to.getNode());
                graph.addEdge(parent, child, to.getDuration(), to.getName() );
            }
        }

        DeliverySimulator deliverySimulator = new DeliverySimulator(trains, packageList);

        List<Package> packages = new ArrayList<>();

        packages.addAll(packageList);
        if (packages.isEmpty()){
            throw new RuntimeException("there's no package to deliver");
        }
        //todo assigning package to trains
        Set<TrainTravel> trainTravels = deliverySimulator.assignPackages();

        while (!trainTravels.isEmpty()){
            Iterator<TrainTravel> iterator = trainTravels.iterator();
            while (iterator.hasNext()){
                TrainTravel next = iterator.next();
                String startNode = next.getStart();

                Iterator<Package> packageIterator = next.getPackages().iterator();
                while (packageIterator.hasNext()){
                    Package pkg = packageIterator.next();
                    System.out.print("train "+next.getTrain() + " current weight "+next.getCurrentCapacity()+ " delivered package "+ pkg.getName() + " start at "+ startNode + " destination "+ pkg.getDestination());
                    GraphTraversal traversal = new GraphTraversal(graph);
                    Map<String, Integer> computePathResult = traversal.computePath(new Vertex(startNode));
                    System.out.println(" computed distance summary "+ computePathResult);
                    List<String> shortestPath = traversal.getShortestPath(traversal.getPreviousNode(), new Vertex(startNode), new Vertex(pkg.getDestination()));
                    System.out.print(" using path "+ shortestPath);
                    int duration = computePathResult.get(pkg.getDestination());
                    System.out.println(" duration take = "+ duration);
                    startNode = pkg.getDestination();
                    packageIterator.remove();

                }
                iterator.remove();
            }
        }

    }

}