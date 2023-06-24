package controller;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Docente;
import model.Funcionario;
import model.Tecnico;

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
        setArquivo("db.txt");
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
        setArquivo("db.txt");
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

    
//    @Override
//    public boolean ler() {
//        if (getArquivo() == null) {
//            return false;
//        }
//        try {
//            if (getArquivo().length() == 0L && getArquivo().isFile()) {
//                lista = new ArrayList<>();
//                return true;
//            }
//            leitor = new ObjectInputStream(new FileInputStream(getArquivo()));
//            lista = (ArrayList<Departamento>) leitor.readObject();
//            leitor.close();
//            return true;
//        } catch (ClassNotFoundException | IOException erro) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean escrever(boolean append) {
//        if (arquivo != null && arquivo.isFile()) {
//            try {
//                escritor = new ObjectOutputStream(new FileOutputStream(arquivo, append));
//                escritor.writeObject(lista);
//                escritor.close();
//                return true;
//            } catch (IOException erro) {
//                System.err.println(erro.getMessage() + "Erro ao escrever arquivo binário.");
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
    
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
                gastoTotal += funcionario.calcularSalario();
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
        StringBuilder stBuilder = new StringBuilder();
        
        for (Departamento dp : lista) {
            List<Funcionario> funcionarios = dp.getFuncionarios();
            
            for (Funcionario fc : funcionarios) {
                
                double salario = fc.calcularSalario();
                if (salario >= faixaInicial && salario <= faixaFinal) {
                    stBuilder   .append("Funcionário{")
                                .append("nome='").append(fc.getNome()).append('\'')
                                .append(", departamento='").append(dp.getNome()).append('\'')
                                .append(", salario=").append(salario)
                                .append("}\n");
                }
            }
        }
        return stBuilder.toString();
    }
    
    public String tecnicoRelatorio() {
        StringBuilder stBuilder = new StringBuilder();
        
        for (Departamento dp : lista) {
            List<Funcionario> funcionarios = dp.getFuncionarios();
            
            for (Funcionario fc : funcionarios) {
                
                if (fc instanceof Tecnico) {
                stBuilder   .append("Funcionário Técnico{")
                            .append("nome='").append(fc.getNome()).append('\'')
                            .append(", departamento='").append(dp.getNome()).append('\'')
                            .append(", salario=").append(fc.getSalario())
                            .append("}\n");
            }
            }
        }
        
        return stBuilder.toString();
    }
    
    public String docenteRelatorio() {
        StringBuilder stBuilder = new StringBuilder();
        
        for (Departamento dp : lista) {
            List<Funcionario> funcionarios = dp.getFuncionarios();
            
            for (Funcionario fc : funcionarios) {
                
                if (fc instanceof Docente) {
                stBuilder   .append("Funcionário Docente{")
                            .append("nome='").append(fc.getNome()).append('\'')
                            .append(", departamento='").append(dp.getNome()).append('\'')
                            .append(", salario=").append(fc.getSalario())
                            .append("}\n");
                }
            }
        }
        
        return stBuilder.toString();    
    }
    
    public String docenteEfetivoRelatorio() {
        StringBuilder stBuilder = new StringBuilder();
        
        for (Departamento dp : lista) {
            List<Funcionario> funcionarios = dp.getFuncionarios();
            
            for (Funcionario fc : funcionarios) {
                
                if (fc instanceof Docente && ((Docente) fc).isEfetivo()) {
                stBuilder   .append("Funcionário Docente Efetivo{")
                            .append("nome='").append(fc.getNome()).append('\'')
                            .append(", departamento='").append(dp.getNome()).append('\'')
                            .append(", salario=").append(fc.getSalario())
                            .append("}\n");
                }
            }
        }
        
        return stBuilder.toString();    
    }
    
    public String docenteSubstitutoRelatorio() {
        StringBuilder stBuilder = new StringBuilder();
        
        for (Departamento dp : lista) {
            List<Funcionario> funcionarios = dp.getFuncionarios();
            
            for (Funcionario fc : funcionarios) {
                
                if (fc instanceof Docente && !((Docente) fc).isEfetivo()) {
                stBuilder   .append("Funcionário Docente Substituto{")
                            .append("nome='").append(fc.getNome()).append('\'')
                            .append(", departamento='").append(dp.getNome()).append('\'')
                            .append(", salario=").append(fc.getSalario())
                            .append("}\n");
                }
            }
        }
        
        return stBuilder.toString();    
    }
    
    public String departamentoInformacoes(int idDep) {
        StringBuilder stBuilder = new StringBuilder();
        
        for (Departamento dp : lista) {
            
            if (dp.getCodigo() == idDep) {
                stBuilder.append("Departamento: ").append(dp.getNome()).append("\n");
                stBuilder.append("Funcionarios: \n");
                
                List<Funcionario> fc = dp.getFuncionarios();
                
                for(Funcionario funcionario : fc) {
                    stBuilder.append(" - ").append(funcionario.getNome()).append("\n");
                }
                
                stBuilder.append("Gasto com funcionários: ").append(dp.getGastoTotalFuncionarios()).append("\n");
                return stBuilder.toString();
            }
        }
        
        return "Erro: Departamento não encontrado!";
    }
    
    public String funcionarioInformacoes(int idFunc) {
        StringBuilder stBuilder = new StringBuilder();
        
        for (Departamento dp : lista) {
            List<Funcionario> funcionarios = dp.getFuncionarios();
            
            for (Funcionario fc : funcionarios) {
                
                if (fc.getCodigoFunc().equals(idFunc)) {
                stBuilder   .append("Funcionário{")
                            .append("nome='").append(fc.getNome()).append('\'')
                            .append(", departamento='").append(dp.getNome()).append('\'')
                            .append(", código=").append(fc.getCodigoFunc())
                            .append(", salário=").append(fc.calcularSalario())
                            .append("}\n");
                    return stBuilder.toString();
                }
            }
        }
        
        return "Erro: Funcionario não encontrado!";
    }
    
        public String funcionarioInformacoesNome(String nome) {
        StringBuilder stBuilder = new StringBuilder();
        
        for (Departamento dp : lista) {
            List<Funcionario> funcionarios = dp.getFuncionarios();
            
            for (Funcionario fc : funcionarios) {
                
                if (fc.getNome().equals(nome)) {
                stBuilder   .append("Funcionário{")
                            .append("nome='").append(fc.getNome()).append('\'')
                            .append(", departamento='").append(dp.getNome()).append('\'')
                            .append(", código=").append(fc.getCodigoFunc())
                            .append(", salário=").append(fc.calcularSalario())
                            .append("}\n");
                }
            }
        }
        return stBuilder.toString();
//        return "Erro: Funcionario não encontrado!";
    }

}