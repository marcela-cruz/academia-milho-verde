/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.model;

import com.application.academia.controller.GeradorId;

/**
 * Esta classe representa um cliente da academia.
 *
 * @author marce
 */
public class Cliente {

    private String id;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String cpf;

    /**
     * Construtor sem argumentos.
     * Inicializa o cliente com valores padrão (se houver).
     */
    public Cliente() {

    }

    /**
     * Construtor completo para o cliente.
     *
     * @param nome Nome do cliente.
     * @param endereco Endereço do cliente.
     * @param telefone Telefone do cliente.
     * @param email Email do cliente.
     * @param cpf CPF do cliente.
     */
    public Cliente(String nome, Endereco endereco, String telefone, String email, String cpf) {
        this.id = GeradorId.gerarId();
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna uma representação em string do objeto Cliente.
     *
     * @return Uma string representando o estado do Cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", cpf=" + cpf + '}';
    }
}
