/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.model;

/**
 *
 * @author marce
 */
public class Despesa {
    
    private String descricao;
    private double valor;

    /**
     * Construtor sem argumentos. Inicializa a despesa com valores padrão (se
     * houver).
     */
    public Despesa() {
    }

    /**
     * 
     * @param descricao
     * @param valor 
     */
    public Despesa(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Retorna uma representação em string do objeto Despesa.
     *
     * @return Uma string representando o estado do Despesa.
     */
    @Override
    public String toString() {
        return "Despesa{" + "descricao=" + descricao + ", valor=" + valor + '}';
    }
}
