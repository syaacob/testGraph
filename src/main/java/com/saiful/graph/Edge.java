package com.saiful.graph;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Edge {
    @NonNull
    private String name;
    private Integer weight;
}
