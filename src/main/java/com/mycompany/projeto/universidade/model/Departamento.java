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
    public Funcionario[] funcionarios;

    public Departamento(String codigo, String nome, Funcionario[] Funcionarios) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcionarios = Funcionarios;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codigo=" + codigo + ", nome=" + nome + ", Funcionarios=" + funcionarios + '}';
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
        return funcionarios;
    }

    public void setFuncionarios(Funcionario[] Funcionarios) {
        this.funcionarios = Funcionarios;
    }
    
}
