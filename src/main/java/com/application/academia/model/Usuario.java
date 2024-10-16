/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.model;

import com.application.academia.controller.GeradorId;

/**
 * Esta classe representa um usuário do sistema.
 * 
 * @author marce
 */
public class Usuario {
    
    public enum TipoUsuario {
        ADMINISTRADOR, FUNCIONARIO
    }
    
    private String id;
    private String login;
    private String senha;
    private TipoUsuario tipo;

    /**
     * Construtor sem argumentos.
     * Inicializa o usuário com valores padrão (se houver).
     */
    public Usuario() {
    }

    /**
     * Construtor completo para o usuário.
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @param tipo Tipo de usuário (Administrador ou Funcionário).
     */
    public Usuario(String login, String senha, TipoUsuario tipo) {
        this.id = GeradorId.gerarId();
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Verifica se o usuário fornecido corresponde ao login e senha armazenados.
     *
     * @param login Login do usuário a ser autenticado.
     * @param senha Senha do usuário a ser autenticado.
     * @return true se o login e senha correspondem, false caso contrário.
     */
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
    /**
     * Verifica se o usuário possui o tipo de ADMINISTRADOR.
     *
     * @return true se o usuário é administrador, false caso contrário.
     */
    public boolean isAdministrador() {
        return this.tipo == TipoUsuario.ADMINISTRADOR;
    }

    /**
     * Retorna uma representação em string do objeto Usuario.
     *
     * @return Uma string representando o estado do Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + '}';
    }
}
