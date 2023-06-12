/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author caiotavares
 */
public class teste {
    public static void main(String[] args) {
        
        List<String> lista = Arrays.asList("caio", "joão", "jean");
        
        lista.stream().filter(x -> x.contains("j")).map(x -> {
            if (x.contains("o")){
                x="joao";
            }
            return x;
        }).sorted().forEach(System.out::println);
        
        Predicate<Integer> qualquernome = x -> x % 2 == 0;
        System.out.println(verifica(9, qualquernome));
    }
    
    
    public static boolean verifica(int x, Predicate<Integer> c ){
        return c.test(x);
        
    }
}
