/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.model;

import com.application.academia.controller.GeradorId;

/**
 *
 * @author marce
 */
public class Funcionario {
    
    private String id;
    private String nomeCompleto;
    private String senha;
    private String nivelDeAcesso;

    public Funcionario() {
    }

    public Funcionario(String nomeCompleto, String senha, String nivelDeAcesso) {
        this.id = GeradorId.gerarId();
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public String getId() {
        return id;
    }

    public String getnomeCompleto() {
        return nomeCompleto;
    }

    public void setnomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getsenha() {
        return senha;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }

    public String getnivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setnivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    /**
     * Retorna uma representação em string do objeto Funcionário.
     *
     * @return Uma string representando o estado do Funcionário.
     */
    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nomeCompleto=" + nomeCompleto + ", senha=" + senha + ", nivelDeAcesso=" + nivelDeAcesso + '}';
    }
}
