/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto.universidade;

import com.mycompany.projeto.universidade.controller.UniversidadeController;
import com.mycompany.projeto.universidade.model.*;

import javax.swing.*;

import java.util.Arrays;

import static com.mycompany.projeto.universidade.Helper.gerarHash;

/**
 *
 * @author caiotavares
 */
public class ProjetoUniversidade {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Gui gui = new Gui();
        JPanel panel = new JPanel();
        panel.add(gui);

        JFrame frame = new JFrame("UNESP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // Testes
//        Departamento departamento0 = new Departamento(
//                gerarHash(),
//                "Departamento de Ciência da Computação",
//                null
//        );
//        UniversidadeController controller = new UniversidadeController();
//        controller.adicionarDepartamento(departamento0);
//
//        Funcionario tecnico = new Tecnico("a", "caio", 4000, "D1", "O cara");
//        Funcionario tecnico1 = new Tecnico( "b", "Tavares", 10000, "D3", "O homi");
//        departamento0.adicionarFuncionario(tecnico, "Tecnico.txt");
//        departamento0.adicionarFuncionario(tecnico1, "Tecnico.txt");
//
//        Funcionario efetivo = new Efetivo("c", "Gabriel", 60000, "LVL1", "CC");
//        departamento0.adicionarFuncionario(efetivo, "Efetivos.txt");
//
//        System.out.println(Arrays.toString(departamento0.lerFuncionarios("Efetivos.txt")));
    }
}
