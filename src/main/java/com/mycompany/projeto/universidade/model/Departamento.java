/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.universidade.model;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author caiotavares
 */
public class Departamento implements Serializable {
    public String codigo;
    public String nome;
    public Funcionario[] funcionarios;

    public Departamento(String codigo, String nome, Funcionario[] Funcionarios) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcionarios = Funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario, String nomeArquivo) {
        if (funcionarios == null) {
            funcionarios = new Funcionario[1];
            funcionarios[0] = funcionario;
        } else {
            Funcionario[] novoArray = new Funcionario[funcionarios.length + 1];
            System.arraycopy(funcionarios, 0, novoArray, 0, funcionarios.length);
            novoArray[funcionarios.length] = funcionario;
            funcionarios = novoArray;
        }

        gravarFuncionario(funcionario, nomeArquivo);
    }

//    public void removerFuncionario(String codigoFuncionario) {
//        if (funcionarios == null || funcionarios.length == 0) {
//            return;
//        }
//
//        int indice = -1;
//        for (int i = 0; i < funcionarios.length; i++) {
//            if (funcionarios[i].getCodigo().equals(codigoFuncionario)) {
//                indice = i;
//                break;
//            }
//        }
//
//        if (indice == -1) {
//            return;
//        }
//
//        Funcionario funcionarioRemovido = funcionarios[indice];
//
//        Funcionario[] novoArray = new Funcionario[funcionarios.length - 1];
//
//        if (indice > 0) {
//            System.arraycopy(funcionarios, 0, novoArray, 0, indice);
//        }
//
//        if (indice < funcionarios.length - 1) {
//            System.arraycopy(funcionarios, indice + 1, novoArray, indice, funcionarios.length - indice - 1);
//        }
//
//        funcionarios = novoArray;
//
////        atualizarArquivoRemocaoFuncionario(funcionarioRemovido);
//    }

//    public void getFuncionarios(String nomeArquivo) {
//        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
//            List<Funcionario> listaFuncionarios = new ArrayList<>();
//
//            while (scanner.hasNextLine()) {
//                String linha = scanner.nextLine();
//                if (linha.isEmpty()) {
//                    continue;
//                }
//
//                // Cria um objeto Funcionario com base na linha lida
//                Funcionario funcionario = criarFuncionarioAPartirDaLinha(linha);
//                listaFuncionarios.add(funcionario);
//            }
//
//            // Converte a lista de funcionários para um array e atribui ao array funcionarios do Departamento
//            funcionarios = listaFuncionarios.toArray(new Funcionario[0]);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public void gravarFuncionario(Funcionario funcionario, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("db/" + nomeArquivo, true))) {
            outputStream.writeObject(funcionario);
            outputStream.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Funcionario[] lerFuncionarios(String nomeArquivo) {
        Funcionario[] funcionarios = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("db/" + nomeArquivo))) {
            ArrayList<Funcionario> funcionariosTemp = new ArrayList<>();

            while (true) {
                try {
                    Funcionario funcionario = (Funcionario) inputStream.readObject();
                    if (funcionario != null) {
                        funcionariosTemp.add(funcionario);
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            funcionarios = funcionariosTemp.toArray(new Funcionario[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

//    @Override
//    public String toString() {
//        return codigo + "," +
//                nome + "," +
//                Arrays.toString(funcionarios) + '}';
//    }

    @Override
    public String toString() {
        return codigo + "," +
                nome + ",";
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
