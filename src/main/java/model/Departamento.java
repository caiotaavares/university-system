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
        StringBuilder sb = new StringBuilder();
        sb.append("Departamento{")
          .append("codigo=").append(codigo)
          .append(", nome='").append(nome).append('\'')
          .append(", funcionarios=[");

        if (funcionarios != null && !funcionarios.isEmpty()) {
            for (int i = 0; i < funcionarios.size(); i++) {
                sb.append(funcionarios.get(i).toString());
                if (i < funcionarios.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        sb.append("]}\n");
        return sb.toString();
    }
    
    public double getGastoTotalFuncionarios() {
        double total = 0;
        for (Funcionario funcionario : funcionarios) {
            total += funcionario.calcularSalario();
        }
        return total;
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