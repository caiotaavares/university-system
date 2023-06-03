/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

/**
 *
 * @author caiotavares
 */
public abstract class Funcionario {
    public String codigo;
    public String nome;
    public double salario;
    public String nivel;
    
    abstract double calcularSalario();
}
