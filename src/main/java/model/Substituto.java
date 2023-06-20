/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * author caiotavares
 */
public class Substituto extends Docente {
    public int cargaHoraria; //12 ou 24 horas.

    public Substituto(String nome, double salario, String nivel, String titulacao, int cargaHoraria) {
        super(nome, salario, nivel, titulacao);
        this.cargaHoraria = cargaHoraria;
    }
    
    @Override
    public String toString() {
        return String.format("{%n  \"codigoFunc\": %d,%n  \"nome\": \"%s\",%n  \"salario\": %.2f,%n  \"nivel\": \"%s\",%n  \"titulacao\": \"%s\",%n  \"cargaHoraria\": %d%n}",
                             getCodigoFunc(), getNome(), getSalario(), getNivel(), getTitulacao(), getCargaHoraria());
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}