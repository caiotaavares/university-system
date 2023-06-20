package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ControllerArquivoBinario<Departamento> extends ControllerArquivo {
    private List<Departamento> lista = new ArrayList<>();
    private ObjectInputStream leitor = null;
    private ObjectOutputStream escritor = null;

    public List<Departamento> getLista() {
        return lista;
    }

    public void setLista(List<Departamento> lista) {
        this.lista = lista;
    }

    @Override
    public boolean ler() {
        if (getArquivo() == null) {
            return false;
        }
        try {
            if (getArquivo().length() == 0L && getArquivo().isFile()) {
                lista = new ArrayList<>();
                return true;
            }
            leitor = new ObjectInputStream(new FileInputStream(getArquivo()));
            lista = (ArrayList<Departamento>) leitor.readObject();
            leitor.close();
            return true;
        } catch (ClassNotFoundException | IOException erro) {
            return false;
        }
    }

    @Override
    public boolean escrever(boolean append) {
        if (arquivo != null && arquivo.isFile()) {
            try {
                escritor = new ObjectOutputStream(new FileOutputStream(arquivo, append));
                escritor.writeObject(lista);
                escritor.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao escrever arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }
    
//    public T consLista(T pessoa){
//        return lista.stream().filter(x -> x.getIdPessoa().equals(pessoa.getIdPessoa())).findFirst().orElse(null);
//    }
    
    
//    public boolean deletePessoa(T pessoa){
//       
//        if(pessoa == null){
//            return false;
//        }
//        final T aux = pessoa;
//        pessoa = consLista(pessoa);
//        if(pessoa == null){
//            return false;
//        }
//        lista.remove(pessoa);
//        escrever(false);
//        return true;
//    }
//    
//    public boolean updatePessoa(T pessoa){
//        AtomicInteger verifica = new AtomicInteger(0);//Serve para thread Safe...
//
//        lista = lista.stream().
//                map(x -> {
//                    if (x.getIdPessoa().equals(pessoa.getIdPessoa())) {
//                        verifica.set(1);
//                        return pessoa;
//                    }
//                    return x;
//                }).collect(Collectors.toList());
//
//        if (verifica.get() == 1) {
//            escrever(false);
//        }
//
//        return verifica.get() == 1;
//    }
}