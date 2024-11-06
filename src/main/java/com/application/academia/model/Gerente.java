/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.model;

/**
 *
 * @author marce
 */
public class Gerente extends Funcionario {

    /**
     * Construtor sem argumentos. Inicializa o gerente com valores padrão (se
     * houver).
     */
    public Gerente() {
    }

    /**
     *
     * @param nome
     * @param dataNascimento
     * @param idade
     * @param salario
     * @param login
     * @param senha
     * @param tipo
     */
    public Gerente(String nome, String dataNascimento, int idade, double salario, String login, String senha, TipoUsuario tipo) {
        super(nome, dataNascimento, idade, salario, login, senha, tipo);
    }

    /**
     * Retorna uma representação em string do objeto Gerente.
     *
     * @return Uma string representando o estado do Gerente.
     */
    @Override
    public String toString() {
        return "Gerente{" + '}';
    }
}
