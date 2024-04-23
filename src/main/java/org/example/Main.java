package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
        list.stream().collect(Collectors.summingInt(Integer::intValue));

    }




}
