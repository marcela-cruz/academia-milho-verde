/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.model;

/**
 *
 * @author marce
 */
public class Aula {
    
    private String tipo; // spinning, musculação, fit dance e pilates
    private String sala;
    private double valor;
    private Instrutor instrutor;

    public Aula() {
    }

    public Aula(String tipo, String sala, double valor, Instrutor instrutor) {
        this.tipo = tipo;
        this.sala = sala;
        this.valor = valor;
        this.instrutor = instrutor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    @Override
    public String toString() {
        return "Aula{" + "tipo=" + tipo + ", sala=" + sala + ", valor=" + valor + ", instrutor=" + instrutor + '}';
    }
}
