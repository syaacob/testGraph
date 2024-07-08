package com.saiful;


import com.saiful.input.Package;
import com.saiful.input.Train;

import java.util.*;

public class DeliverySimulator {
    private List<Train> trains;
    private List<Package> packageList;
    private List<Package> unAssignPackage = new ArrayList<>();

    public DeliverySimulator(List<Train> trains, List<Package> packageList) {
        this.trains = trains;
        this.packageList = packageList;
    }

    public Set<TrainTravel> assignPackages() {
        Set<TrainTravel> trainTravels = new HashSet<>();
        List<Package> packages = new ArrayList<>();
        packages.addAll(packageList);
        if (packages == null || packages.isEmpty()) {
            throw new RuntimeException("there's no package to deliver");
        }

        if(trains == null || trains.isEmpty()){
            throw new RuntimeException("there's no train to assign");
        }
        System.out.println("total " + packages.size() + " package need to deliver");
        while (!packages.isEmpty()) {
            Iterator<Train> trainIterator = trains.iterator();
            while (trainIterator.hasNext()) {
                Train t = trainIterator.next();

                Iterator<Package> packageIterator = packages.iterator();
                TrainTravel trainTravel = new TrainTravel(t.getName(), t.getStarting(), t.getCapacity());
                while (packageIterator.hasNext()) {
                    Package pckg = packageIterator.next();
                    if (pckg.getStarting().equals(t.getStarting()) && trainTravel.canCarry(pckg.getWeight())) {
                        System.out.println("train " + t.getName() + " loading package " + pckg.getName() + " weight " + pckg.getWeight());
                        trainTravel.setDestination(pckg.getDestination());
                        trainTravel.loadPackage(pckg);
                        trainTravels.add(trainTravel);
                        packageIterator.remove();
                    } else {
                        //System.out.println("package "+pckg.getName() + " is over limit ");
                        if(!trainIterator.hasNext()){
                            //System.out.println("no train available to assign package");
                            unAssignPackage.add(pckg);
                            packageIterator.remove();
                        }
                    }
                }

            }
        }

        return trainTravels;
    }

    public List<Package> getUnAssignPackage() {
        return unAssignPackage;
    }
}
