/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * author caiotavares
 */
public class DepartamentoTableModel extends AbstractTableModel {
    private List<Departamento> departamentos;
    private String[] columnNames = {"ID", "Nome"};

    public DepartamentoTableModel(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int getRowCount() {
        return departamentos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Departamento departamento = departamentos.get(rowIndex);
        switch (columnIndex) {
            case 0: return departamento.getId();
            case 1: return departamento.getDescricao();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}