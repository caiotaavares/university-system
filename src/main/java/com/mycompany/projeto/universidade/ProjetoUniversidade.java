/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto.universidade;

import com.mycompany.projeto.universidade.model.Departamento;
import com.mycompany.projeto.universidade.model.Funcionario;
import com.mycompany.projeto.universidade.model.Tecnico;

import javax.swing.JFrame;

import static com.mycompany.projeto.universidade.Helper.gerarHash;

/**
 *
 * @author caiotavares
 */
public class ProjetoUniversidade {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Gui gui = new Gui();
        JFrame frame = new JFrame("UNESP");
        
        frame.add(gui);
        frame.pack();
        frame.setVisible(true);

        // Testes
        Departamento departamento0 = new Departamento(
                gerarHash(),
                "Departamento de Ciência da Computação",
                null
        );
        Funcionario tecnico = new Tecnico(gerarHash(), "caio", 123456, "D1", "aaaa");
        Funcionario tecnico1 = new Tecnico( gerarHash(), "caio", 123456, "D1", "aaaa");
        departamento0.adicionarFuncionario(tecnico);
        departamento0.adicionarFuncionario(tecnico1);
//        departamento0.removerFuncionario(tecnico1.getCodigo());
    }
}
