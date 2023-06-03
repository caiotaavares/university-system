/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto.universidade;

import javax.swing.JFrame;

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
    }
}
