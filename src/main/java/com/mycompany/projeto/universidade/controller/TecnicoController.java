package com.mycompany.projeto.universidade.controller;

import com.mycompany.projeto.universidade.model.Tecnico;

import java.util.ArrayList;
import java.util.List;

public class TecnicoController {
    private final List<Tecnico> tecnicos;

    public TecnicoController() {
        tecnicos = new ArrayList<>();
    }

    public void criarTecnico(String codigo, String nome, double salario, String nivel, String funcao) {
        Tecnico tecnico = new Tecnico(codigo, nome, salario, nivel, funcao);
        tecnicos.add(tecnico);
    }

    public List<Tecnico> listarTecnicos() {
        return tecnicos;
    }

    public Tecnico buscarTecnicoPorCodigo(String codigo) {
        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getCodigo().equals(codigo)) {
                return tecnico;
            }
        }
        return null;
    }

    public void atualizarTecnico(String codigo, String nome, double salario, String nivel, String funcao) {
        Tecnico tecnico = buscarTecnicoPorCodigo(codigo);
        if (tecnico != null) {
            tecnico.setNome(nome);
            tecnico.setSalario(salario);
            tecnico.setNivel(nivel);
            tecnico.setFuncao(funcao);
        }
    }

    public void excluirTecnico(String codigo) {
        Tecnico tecnico = buscarTecnicoPorCodigo(codigo);
        if (tecnico != null) {
            tecnicos.remove(tecnico);
        }
    }
}
