/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * author caiotavares
 */
public class Departamento implements Serializable {
    protected static Integer ID = 1;
    private Integer codigo;
    private String nome;
    private List<Funcionario> funcionarios;

    public Departamento(String nome) {
        this.codigo = ID;
        this.nome = nome;
        this.funcionarios = null;
        ID++;
    }

    public Departamento() {

    }

    @Override
    public String toString() {
        return "Departamento{" + "codigo=" + codigo + ", nome=" + nome + ", funcionarios=" + funcionarios + '}';
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Integer getId() {
        return codigo;
    }

    public String getDescricao() {
        return nome;
    }
}