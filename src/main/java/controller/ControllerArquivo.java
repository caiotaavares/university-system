package controller;

import java.io.File;
import javax.swing.JFileChooser;

public abstract class ControllerArquivo {
    protected File arquivo = null;
    private JFileChooser chooser;

    public abstract boolean ler();
    public abstract boolean escrever(boolean append);

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(String TextoBotao) {
        chooser = new JFileChooser();
        chooser.setSelectedFile(new File("db.txt"));
        arquivo = chooser.getSelectedFile();
    }
}