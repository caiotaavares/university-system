package com.mycompany.projeto.universidade.controller;

import com.mycompany.projeto.universidade.model.Substituto;

import java.util.ArrayList;
import java.util.List;

public class SubstitutoController {
    private List<Substituto> substitutos;

    public SubstitutoController() {
        substitutos = new ArrayList<>();
    }

    public void criarSubstituto(String codigo, String nome, double salario, String nivel, int cargaHoraria) {
        Substituto substituto = new Substituto(codigo, nome, salario, nivel);
        substituto.setCargaHoraria(cargaHoraria);
        substitutos.add(substituto);
    }

    public List<Substituto> listarSubstitutos() {
        return substitutos;
    }

    public Substituto buscarSubstitutoPorCodigo(String codigo) {
        for (Substituto substituto : substitutos) {
            if (substituto.getCodigo().equals(codigo)) {
                return substituto;
            }
        }
        return null;
    }

    public void atualizarSubstituto(String codigo, String nome, double salario, String nivel, int cargaHoraria) {
        Substituto substituto = buscarSubstitutoPorCodigo(codigo);
        if (substituto != null) {
            substituto.setNome(nome);
            substituto.setSalario(salario);
            substituto.setNivel(nivel);
            substituto.setCargaHoraria(cargaHoraria);
        }
    }

    public void excluirSubstituto(String codigo) {
        Substituto substituto = buscarSubstitutoPorCodigo(codigo);
        if (substituto != null) {
            substitutos.remove(substituto);
        }
    }
}
