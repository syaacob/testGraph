package com.saiful;

import com.saiful.input.Package;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class TrainTravel {
    private String train;
    private String start;
    private String destination;
    private int currentCapacity;
    private int limit;
    private List<Package> packages;

    public TrainTravel(String train, String start, int limit){
        this.train = train;
        this.start = start;
        this.limit = limit;
        this.packages = new ArrayList<>();
    }

    public boolean canCarry(int load){
        return currentCapacity + load <= limit;
    }

    public void loadPackage(Package pkg){
        packages.add(pkg);
        currentCapacity += pkg.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainTravel that)) return false;
        return Objects.equals(train, that.train);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(train);
    }
}
