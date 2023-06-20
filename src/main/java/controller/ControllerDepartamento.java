package controller;

import java.util.ArrayList;
import java.util.List;
import model.Departamento;
import model.Funcionario;

/**
 *
 * @author caiotavares
 */
public class ControllerDepartamento {
    
    public void adicionarFuncionario(Funcionario funcionario, Departamento departamento) {
        List<Funcionario> funcionarios = departamento.getFuncionarios();
        if (funcionarios == null) {
            funcionarios = new ArrayList<>();
            departamento.setFuncionarios(funcionarios);
        }
        funcionarios.add(funcionario);
    }
}
