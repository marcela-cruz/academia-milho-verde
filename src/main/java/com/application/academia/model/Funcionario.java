/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.model;

import com.application.academia.service.Padronizacao;

/**
 *
 * @author marce
 */
public class Funcionario extends Usuario {

    private String nome;
    private String dataNascimento;
    private int idade;
    private double salario;

    /**
     * Construtor sem argumentos. Inicializa o funcinário com valores padrão (se
     * houver).
     */
    public Funcionario() {
        
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
    public Funcionario(String nome, String dataNascimento, int idade, double salario, String login, String senha, TipoUsuario tipo) {    
        super(login, senha, tipo);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.idade = Padronizacao.calcularIdade(dataNascimento);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Retorna uma representação em string do objeto Funcionario.
     *
     * @return Uma string representando o estado do Funcionario.
     */
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", dataNascimento=" + dataNascimento + ", idade=" + idade + ", salario=" + salario + '}';
    }
}
