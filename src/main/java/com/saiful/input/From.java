package com.saiful.input;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class From {
    private String from;
    private List<To> to = new ArrayList<>();
}
