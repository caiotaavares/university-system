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
public class Tecnico extends Funcionario implements Serializable {
    public String funcao; //Assessor; Laboratório; Secretário.

    public Tecnico(String nome, double salario, String nivel, String funcao) {
        super(nome, salario, nivel);
        this.funcao = funcao;
    }
    
    public Tecnico(String nome, double salario, String nivel) {
        super(nome, salario, nivel);
    }

    @Override
    public double calcularSalario() {
        return (salario * 1.1);
    }

    @Override
    public String toString() {
        return  "[" + codigoFunc + "," +
                nome + "," +
                salario + "," +
                nivel + "," +
                funcao + "]";
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}