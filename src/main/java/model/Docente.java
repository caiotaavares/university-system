/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * author caiotavares
 */
public abstract class Docente extends Funcionario {
    public String titulacao; //Graduação; Mestrado; Doutorado; Livre-Docente; Titular.

    public Docente(String nome, double salario, String nivel, String titulacao) {
        super(nome, salario, nivel);
        this.titulacao = titulacao;
    }

    @Override
    public abstract double calcularSalario();

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}
