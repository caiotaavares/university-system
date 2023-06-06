/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

import java.io.Serializable;

/**
 *
 * @author caiotavares
 */
public class Tecnico extends Funcionario implements Serializable {
    public String funcao; //Assessor; Laboratório; Secretário.

    public Tecnico(String codigo, String nome, double salario, String nivel, String funcao) {
        super(codigo, nome, salario, nivel);
        this.funcao = funcao;
    }

    @Override
    public double calcularSalario() {
        return (salario * 1.1);
    }

    @Override
    public String toString() {
        return  funcao + "," +
                codigo + "," +
                nome + "," +
                salario + "," +
                nivel + ",";
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
