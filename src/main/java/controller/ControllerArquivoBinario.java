package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Funcionario;

public class ControllerArquivoBinario<Departamento extends model.Departamento> extends ControllerArquivo {    
    private List<Departamento> lista = new ArrayList<>();
    private ObjectInputStream leitor = null;
    private ObjectOutputStream escritor = null;

    public List<Departamento> getLista() {
        return lista;
    }
    
    public List<Departamento> getListaResFunc() {
        
        return null;
        
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
    
    public String resumoDepartamentos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resumo dos Departamentos:\n");
        for (Departamento departamento : lista) {
            sb.append("Departamento: ").append(departamento.getNome()).append("\n");
            sb.append("Quantidade de funcionários: ").append(departamento.getFuncionarios().size()).append("\n");
            sb.append("Gasto total com funcionários: ").append(calcularGastoTotalFuncionarios(departamento)).append("\n\n");
        }
        return sb.toString();
    }

    private double calcularGastoTotalFuncionarios(Departamento departamento) {
        double gastoTotal = 0;
        List<Funcionario> funcionarios = departamento.getFuncionarios();
        if (funcionarios != null) {
            for (Funcionario funcionario : funcionarios) {
                gastoTotal += funcionario.getSalario();
            }
        }
        return gastoTotal;
    }
    
    public List<Departamento> obterDepartamentosPorFaixaDeGasto(double valorMin, double valorMax) {
        return lista.stream()
                .filter(departamento -> departamento.getGastoTotalFuncionarios() >= valorMin
                        && departamento.getGastoTotalFuncionarios() <= valorMax)
                .collect(Collectors.toList());
    }
    
    public String funcionariosSalarioFaixa(double faixaInicial, double faixaFinal) {
        StringBuilder sb = new StringBuilder();
        for (Departamento departamento : lista) {
            List<Funcionario> funcionarios = departamento.getFuncionarios();
            for (Funcionario funcionario : funcionarios) {
                double salario = funcionario.getSalario();
                if (salario >= faixaInicial && salario <= faixaFinal) {
                    sb.append("Funcionário{")
                      .append("nome='").append(funcionario.getNome()).append('\'')
                      .append(", departamento='").append(departamento.getNome()).append('\'')
                      .append(", salario=").append(salario)
                      .append("}\n");
                }
            }
        }
        return sb.toString();
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