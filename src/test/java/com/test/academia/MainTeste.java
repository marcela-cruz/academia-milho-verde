/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.academia;

import com.application.academia.model.Usuario;
import com.application.academia.service.AutenticacaoService;
import java.util.Scanner;

/**
 *
 * @author marce
 */
public class MainTeste {

    public static void main(String[] args) {

        AutenticacaoService autenticacaoService = new AutenticacaoService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("\t1. Login");
            System.out.println("\t2. Cadastrar Novo Usuario");
            System.out.println("\t3. Sair");
            System.out.print("Opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Login ===\n");
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    Usuario usuarioLogado = autenticacaoService.login(login, senha);
                    if (usuarioLogado != null) {
                        System.out.println("Login bem-sucedido! Ola, " + usuarioLogado.getLogin());
                        if (usuarioLogado.isAdministrador()) {
                            System.out.println("Acesso total ao sistema.");
                        } else {
                            System.out.println("Acesso restrito ao sistema.");
                        }
                    } else {
                        System.out.println("Login ou senha invalidos.");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Cadastro de Novo Usuario ===\n");
                    System.out.print("Login: ");
                    String novoLogin = scanner.nextLine();
                    System.out.print("Senha: ");
                    String novaSenha = scanner.nextLine();
                    System.out.print("Tipo de usuário ('A' para Administrador, 'F' para Funcionario): ");
                    String tipoUsuario = scanner.nextLine().toUpperCase();

                    Usuario.TipoUsuario tipo = null;
                    if (tipoUsuario.equals("A")) {
                        tipo = Usuario.TipoUsuario.ADMINISTRADOR;
                    } else if (tipoUsuario.equals("F")) {
                        tipo = Usuario.TipoUsuario.FUNCIONARIO;
                    }

                    if (tipo != null) {
                        Usuario novoUsuario = new Usuario(novoLogin, novaSenha, tipo);
                        autenticacaoService.cadastrarUsuario(novoUsuario);
                        System.out.println("Novo usuario cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo de usuario invalido. Tente novamente.");
                    }
                    break;

                case 3:
                    System.out.println("\nSaindo do sistema...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("\n\tOpção invalida. Tente novamente.\n");
                    break;
            }
        }
    }
}
