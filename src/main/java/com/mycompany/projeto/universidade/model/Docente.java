/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

/**
 *
 * @author caiotavares
 */
public abstract class Docente extends Funcionario {
    public String titulacao; //Graduação; Mestrado; Doutorado; Livre-Docente; Titular.
    
    @Override
    public abstract double calcularSalario();
}
