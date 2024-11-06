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

    /**
     * Construtor sem argumentos. Inicializa a aula com valores padrão (se
     * houver).
     */
    public Aula() {
    }

    /**
     * 
     * @param tipo
     * @param sala
     * @param valor 
     */
    public Aula(String tipo, String sala, double valor) {
        this.tipo = tipo;
        this.sala = sala;
        this.valor = valor;
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

    /**
     * Retorna uma representação em string do objeto Aula.
     *
     * @return Uma string representando o estado do Aula.
     */
    @Override
    public String toString() {
        return "Aula{" + "tipo=" + tipo + ", sala=" + sala + ", valor=" + valor + '}';
    }
}
