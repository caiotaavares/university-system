/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

/**
 *
 * @author caiotavares
 */
public class Substituto extends Docente {
    public int cargaHoraria; //12 ou 24 horas.

    public Substituto(String codigo, String nome, double salario, String nivel) {
        super(codigo, nome, salario, nivel);
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
