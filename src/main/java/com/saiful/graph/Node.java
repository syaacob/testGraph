/**
 * @author: saiful yaacob
 *
 *
 */
package com.saiful.graph;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node implements Comparable<Node>{
    private String name;
    private int weight;

    public Node(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.weight, node.weight);
    }
}
