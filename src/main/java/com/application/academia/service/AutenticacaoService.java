/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.service;

import com.application.academia.dao.JsonManager;
import com.application.academia.model.Usuario;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class AutenticacaoService {

    private static final String ARQUIVO_JSON = "src/main/java/com/application/academia/database/usuarios.json";
    private List<Usuario> usuarios;
    private JsonManager<Usuario> jsonManager;    
    
    public AutenticacaoService() {
        jsonManager = new JsonManager<>();
        usuarios = carregarUsuarios();
    }
    
    private List<Usuario> carregarUsuarios() {
        Type usuarioListType = new TypeToken<ArrayList<Usuario>>() {}.getType();
        List<Usuario> listaUsuarios = jsonManager.lerLista(ARQUIVO_JSON, usuarioListType);
        
        if (listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
            System.out.println("Nenhum usuário encontrado. Criando lista vazia.");
        }
        
        return listaUsuarios;
    }
    
    public Usuario login(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.autenticar(login, senha)) {
                return usuario;
            }
        }
        return null;
    }
    
    public void cadastrarUsuario(Usuario novoUsuario) {
        usuarios.add(novoUsuario);
        salvarUsuariosNoArquivo();
    }

    private void salvarUsuariosNoArquivo() {
        jsonManager.salvarLista(ARQUIVO_JSON, usuarios);
    }
}
