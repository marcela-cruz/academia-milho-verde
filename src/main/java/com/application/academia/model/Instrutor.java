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
public class Instrutor {
    
    private String nomeCompleto;
    private String id;

    public Instrutor() {
    }

    public Instrutor(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        this.id = GeradorId.gerarId();
    }

    public String getnomeCompleto() {
        return nomeCompleto;
    }

    public void setnomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getId() {
        return id;
    }

    /**
     * Retorna uma representação em string do objeto Instrutor.
     *
     * @return Uma string representando o estado do Instrutor.
     */
    @Override
    public String toString() {
        return "Instrutor{" + "nomeCompleto=" + nomeCompleto + ", id=" + id + '}';
    }
}
