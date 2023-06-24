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
        String jarPath = ControllerArquivo.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String directoryPath = new File(jarPath).getParent();
        File dbFile = new File(directoryPath, "db.txt");
        arquivo = dbFile;
    }
}
