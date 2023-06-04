package com.mycompany.projeto.universidade.controller;

import com.mycompany.projeto.universidade.model.Departamento;
import com.mycompany.projeto.universidade.model.Funcionario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UniversidadeController {
    private List<Departamento> departamentos;

    public UniversidadeController() {
        departamentos = new ArrayList<>();
    }

    public void adicionarDepartamento(Departamento departamento) {
        String nomeArquivo = "db/Departamentos.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            writer.println(departamento.toString());
            writer.println();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarFuncionario(String nomeDepartamento, Funcionario funcionario, String nomeArquivo) {
        Departamento departamento = buscarDepartamentoPorNome(nomeDepartamento);
        if (departamento != null) {
            departamento.adicionarFuncionario(funcionario, nomeArquivo);
        }
    }

    public void removerFuncionario(String nomeDepartamento, String codigoFuncionario) {
        Departamento departamento = buscarDepartamentoPorNome(nomeDepartamento);
        if (departamento != null) {
//            departamento.removerFuncionario(codigoFuncionario);
        }
    }

    public void apresentarGeral() {
        double gastoTotal = 0;

        for (Departamento departamento : departamentos) {
            System.out.println("Departamento: " + departamento.getNome());
            System.out.println("Funcionários:");

            Funcionario[] funcionarios = departamento.getFuncionarios();
            for (Funcionario funcionario : funcionarios) {
                System.out.println(" - " + funcionario.getNome());
                gastoTotal += funcionario.getSalario();
            }

            System.out.println();
        }

        System.out.println("Gasto Total com Funcionários: " + gastoTotal);
    }

    public void apresentarResumoDepartamentos() {
        for (Departamento departamento : departamentos) {
            System.out.println("Departamento: " + departamento.getNome());
            System.out.println("Quantidade de Funcionários: " + departamento.getFuncionarios().length);

            double gastoTotal = 0;
            Funcionario[] funcionarios = departamento.getFuncionarios();
            for (Funcionario funcionario : funcionarios) {
                gastoTotal += funcionario.getSalario();
            }

            System.out.println("Gasto Total com Funcionários: " + gastoTotal);
            System.out.println();
        }
    }

    private Departamento buscarDepartamentoPorNome(String nomeDepartamento) {
        for (Departamento departamento : departamentos) {
            if (departamento.getNome().equalsIgnoreCase(nomeDepartamento)) {
                return departamento;
            }
        }
        return null;
    }
}
