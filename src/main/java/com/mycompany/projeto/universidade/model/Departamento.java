/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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

    public void adicionarFuncionario(Funcionario funcionario) {
        if (funcionarios == null) {
            funcionarios = new Funcionario[1];
            funcionarios[0] = funcionario;
        } else {
            Funcionario[] novoArray = new Funcionario[funcionarios.length + 1];
            System.arraycopy(funcionarios, 0, novoArray, 0, funcionarios.length);
            novoArray[funcionarios.length] = funcionario;
            funcionarios = novoArray;
        }

        String codigoFuncionario = funcionario.getCodigo();
        String nomeArquivo = "Funcionarios.txt";

        gravarFuncionario(codigoFuncionario, nomeArquivo);
    }

    public void removerFuncionario(String codigoFuncionario) {
        if (funcionarios == null || funcionarios.length == 0) {
            return;
        }

        int indice = -1;
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i].getCodigo().equals(codigoFuncionario)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            return;
        }

        Funcionario funcionarioRemovido = funcionarios[indice];

        Funcionario[] novoArray = new Funcionario[funcionarios.length - 1];

        if (indice > 0) {
            System.arraycopy(funcionarios, 0, novoArray, 0, indice);
        }

        if (indice < funcionarios.length - 1) {
            System.arraycopy(funcionarios, indice + 1, novoArray, indice, funcionarios.length - indice - 1);
        }

        funcionarios = novoArray;

        // Atualiza o arquivo removendo o funcionário
        atualizarArquivoRemocaoFuncionario(funcionarioRemovido);
    }

    private void atualizarArquivoRemocaoFuncionario(Funcionario funcionarioRemovido) {
        String nomeArquivo = "Funcionarios.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            writer.println("Funcionário removido:");
            writer.println("Nome: " + funcionarioRemovido.getNome());
            writer.println("Código: " + funcionarioRemovido.getCodigo());
            writer.println();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void gravarFuncionario(String codigoFuncionario, String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            writer.println("Departamento: " + this.nome);
            writer.println("Código do Funcionário: " + codigoFuncionario);
            writer.println();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Departamento{" + "codigo=" + codigo + ", nome=" + nome + ", Funcionarios=" + Arrays.toString(funcionarios) + '}';
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
