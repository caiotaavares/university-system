/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static helpers.Helper.*;
import java.io.Serializable;

/**
 *
 * author caiotavares
 */
public abstract class Funcionario implements Serializable {
    protected static Integer ID = 1;
    public Integer codigoFunc;
    public String nome;
    public double salario;
    public String nivel;

    abstract double calcularSalario();

    public Funcionario(String nome, double salario, String nivel) {
        codigoFunc = ID;
        this.nome = nome;
        this.salario = salario;
        this.nivel = nivel;
        ID++;
    }
    
    @Override
    public String toString() {
        return String.format("{%n  \"codigoFunc\": %d,%n  \"nome\": \"%s\",%n  \"salario\": %.2f,%n  \"nivel\": \"%s\"%n}",
                             getCodigoFunc(), getNome(), getSalario(), getNivel());
    }

    public Integer getCodigoFunc() {
        return codigoFunc;
    }

    public void setCodigoFunc(Integer codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}