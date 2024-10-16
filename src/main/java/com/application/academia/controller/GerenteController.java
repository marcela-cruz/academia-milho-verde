/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.controller;

import com.application.academia.model.Despesa;
import com.application.academia.model.Receita;
import com.application.academia.model.Usuario;
import com.application.academia.service.AutenticacaoService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class GerenteController {
    
    private AutenticacaoService autenticacaoService;
    private Usuario usuarioLogado;
    private List<Despesa> despesas;
    private List<Receita> receitas;

    public GerenteController() {
    }

    public GerenteController(AutenticacaoService autenticacaoService, Usuario usuarioLogado, List<Despesa> despesas, List<Receita> receitas) {
        this.autenticacaoService = autenticacaoService;
        this.usuarioLogado = usuarioLogado;
        this.despesas = new ArrayList<>();
        this.receitas = new ArrayList<>();
    }
    
    private boolean isAdmin() {
        return usuarioLogado != null && usuarioLogado.isAdministrador();
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
