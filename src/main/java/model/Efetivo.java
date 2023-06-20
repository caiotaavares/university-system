
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * author caiotavares
 */
public class Efetivo extends Docente implements Serializable {
    public String area; //Biológicas; Exatas; Humanas; Saúde.

    public Efetivo(String nome, double salario, String nivel, String titulacao, String area) {
        super(nome, salario, nivel, titulacao);
        this.area = area;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }
    
    @Override
    public String toString() {
        return String.format("{%n  \"codigoFunc\": %d,%n  \"nome\": \"%s\",%n  \"salario\": %.2f,%n  \"nivel\": \"%s\",%n  \"titulacao\": \"%s\",%n  \"area\": \"%s\"%n}",
                             getCodigoFunc(), getNome(), getSalario(), getNivel(), getTitulacao(), getArea());
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}