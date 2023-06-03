/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

/**
 *
 * @author caiotavares
 */
public class Departamento {
    public String codigo;
    public String nome;
    public Funcionario Funcionarios[];

    public Departamento(String codigo, String nome, Funcionario[] Funcionarios) {
        this.codigo = codigo;
        this.nome = nome;
        this.Funcionarios = Funcionarios;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codigo=" + codigo + ", nome=" + nome + ", Funcionarios=" + Funcionarios + '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario[] getFuncionarios() {
        return Funcionarios;
    }

    public void setFuncionarios(Funcionario[] Funcionarios) {
        this.Funcionarios = Funcionarios;
    }
    
}
