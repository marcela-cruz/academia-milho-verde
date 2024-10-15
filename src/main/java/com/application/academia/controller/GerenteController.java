/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.controller;

import com.application.academia.model.Despesa;
import com.application.academia.model.Receita;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class GerenteController {
    
    private List<Despesa> despesas;
    private List<Receita> receitas;

    public GerenteController() {
    }

    public GerenteController(List<Despesa> despesas, List<Receita> receitas) {
        this.despesas = new ArrayList<>();
        this.receitas = new ArrayList<>();
    }

    // gerenciamento de funcinários  
    public void cadastrarFuncionario() {

    }

    public void editarFuncionario() {

    }

    public void excluirFuncionario() {

    }

    // controle de despesas e receitas
    public void registrarDespesas() {

    }

    public void registrarReceitas() {

    }

    public void visualizarDespesas() {

    }

    public void visualizarReceitas() {

    }

    // balanço financeiro
    public void calcularBalancoMensal() {

    }
}
