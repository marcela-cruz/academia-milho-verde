/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.controller;

import com.application.academia.dao.JsonManager;
import com.application.academia.model.Funcionario;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class FuncinarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();
    JsonManager<Funcionario> jsonManager = new JsonManager<>();
    String filePath = "src/main/java/com/application/academia/database/funcionarios.json";

    public void carregarFuncionarios() {
        List<Funcionario> funcionariosCarregados = jsonManager.lerLista(filePath, new TypeToken<List<Funcionario>>() {
        }.getType());
        if (funcionariosCarregados != null) {
            funcionarios = funcionariosCarregados;
        } else {
            funcionarios = new ArrayList<>();
        }
    }

    public void cadastrarFuncionario() {

    }

    public void listarFuncionario() {

    }

    public void editarFuncionario() {

    }

    public void excluirFuncionario() {

    }
}
