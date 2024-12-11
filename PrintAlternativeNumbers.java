package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintAlternativeNumbers {
    public static void main(String []args){
        int []arrayval = {1,2,3,4,5,6,7,8};
        IntStream.range(0,arrayval.length).filter(i->i%2==0).map(i->arrayval[i]).forEach(System.out::println);
        String str="javaprogram";

    }
}
