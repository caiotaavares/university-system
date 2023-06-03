/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

/**
 *
 * @author caiotavares
 */
public class Efetivo extends Docente {
    public String area; //Biológicas; Exatas; Humanas; Saúde.
    
    @Override
    public double calcularSalario() {
        return salario;
    }

    public Efetivo(String codigo, String nome, double salario, String nivel, String area) {
        super(codigo, nome, salario, nivel);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
