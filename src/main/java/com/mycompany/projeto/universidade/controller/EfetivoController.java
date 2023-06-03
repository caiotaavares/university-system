package com.mycompany.projeto.universidade.controller;

import com.mycompany.projeto.universidade.model.Efetivo;

import java.util.ArrayList;
import java.util.List;

public class EfetivoController {
    private final List<Efetivo> efetivos;

    public EfetivoController() {
        efetivos = new ArrayList<>();
    }

    public void criarEfetivo(String codigo, String nome, double salario, String nivel, String areaAtuacao) {
        Efetivo efetivo = new Efetivo(codigo, nome, salario, nivel, areaAtuacao);
        efetivos.add(efetivo);
    }

    public List<Efetivo> listarEfetivos() {
        return efetivos;
    }

    public Efetivo buscarEfetivoPorCodigo(String codigo) {
        for (Efetivo efetivo : efetivos) {
            if (efetivo.getCodigo().equals(codigo)) {
                return efetivo;
            }
        }
        return null;
    }

    public void atualizarEfetivo(String codigo, String nome, double salario, String nivel, String areaAtuacao) {
        Efetivo efetivo = buscarEfetivoPorCodigo(codigo);
        if (efetivo != null) {
            efetivo.setNome(nome);
            efetivo.setSalario(salario);
            efetivo.setNivel(nivel);
            efetivo.setArea(areaAtuacao);
        }
    }

    public void excluirEfetivo(String codigo) {
        Efetivo efetivo = buscarEfetivoPorCodigo(codigo);
        if (efetivo != null) {
            efetivos.remove(efetivo);
        }
    }
}
