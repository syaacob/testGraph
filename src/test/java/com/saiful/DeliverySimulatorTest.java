package com.saiful;

import com.saiful.input.Package;
import com.saiful.input.Train;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DeliverySimulatorTest {

    @Test
    void testAssignPackages() {
        Train train1 = new Train();
        train1.setName("train_1");
        train1.setCapacity(30);
        train1.setStarting("A");

        Train train2 = new Train();
        train2.setName("train_2");
        train2.setCapacity(50);
        train2.setStarting("B");

        Package package1 = new Package();
        package1.setName("p1");
        package1.setStarting("A");
        package1.setDestination("F");
        package1.setWeight(10);

        Package package2 = new Package();
        package2.setName("p2");
        package2.setStarting("A");
        package2.setDestination("E");
        package2.setWeight(10);

        Package package3 = new Package();
        package3.setName("p3");
        package3.setStarting("B");
        package3.setDestination("C");
        package3.setWeight(50);

        List<Train> trains = Arrays.asList(train1,train2);
        List<Package> packages = Arrays.asList(package1, package2, package3);

        DeliverySimulator deliverySimulator = new DeliverySimulator(trains, packages);
        Set<TrainTravel> results = deliverySimulator.assignPackages();
        List<TrainTravel> trainTravels = new ArrayList<>(results);
        assertEquals(2, trainTravels.size());

        assertEquals("train_2", trainTravels.get(0).getTrain());
        assertEquals(1, trainTravels.get(0).getPackages().size());
        assertEquals(50, trainTravels.get(0).getCurrentCapacity());

        assertEquals("train_1", trainTravels.get(1).getTrain());
        assertEquals(2, trainTravels.get(1).getPackages().size());
        assertEquals(20, trainTravels.get(1).getCurrentCapacity());
    }

    @Test
    void testAssignPackageOverLimit(){
        Train train1 = new Train();
        train1.setName("train_1");
        train1.setCapacity(30);
        train1.setStarting("A");

        Package package1 = new Package();
        package1.setName("p1");
        package1.setStarting("A");
        package1.setDestination("F");
        package1.setWeight(40);

        List<Train> trains = Arrays.asList(train1);
        List<Package> packages = Arrays.asList(package1);

        DeliverySimulator deliverySimulator = new DeliverySimulator(trains, packages);
        Set<TrainTravel> results = deliverySimulator.assignPackages();
        List<TrainTravel> trainTravels = new ArrayList<>(results);
        assertTrue(trainTravels.isEmpty());
        assertEquals(1, deliverySimulator.getUnAssignPackage().size());
    }

    @Test
    void testNoTrainAvailable(){
        Package package1 = new Package();
        package1.setName("p1");
        package1.setStarting("A");
        package1.setDestination("F");
        package1.setWeight(40);
        List<Package> packages = Arrays.asList(package1);
        DeliverySimulator deliverySimulator = new DeliverySimulator(null, packages);

        assertThrows(RuntimeException.class, () ->{
            deliverySimulator.assignPackages();

        }
        );


    }
}