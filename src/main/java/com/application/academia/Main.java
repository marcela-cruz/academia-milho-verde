/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.application.academia;

import com.application.academia.controller.ClienteController;
import com.application.academia.model.Cliente;
import com.application.academia.service.Padronizacao;
import java.util.Scanner;

/**
 *
 * @author marce
 */
public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            ClienteController clienteController = new ClienteController();
            clienteController.carregarClientes();
            
            boolean parada = false;
            int escolha;
            
            do {
                System.out.println("O que deseja fazer? \n\t1. Cadastrar cliente \n\t2. Excluir cliente \n\t3. Listar clientes \n\t4. Sair");
                
                String entrada = scanner.hasNextLine() ? scanner.nextLine() : "";
                try {
                    escolha = Integer.parseInt(entrada); // Tenta converter a string em um inteiro
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    break; // Volta para o menu
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado. Tente novamente.");
                    e.printStackTrace();
                    continue;
                }
                
                switch (escolha){
                    case 1 -> {
                        clienteController.cadastrarCliente();
                        clienteController.carregarClientes();
                        System.out.println("Aluno cadastrado com sucesso!");
                    }
                    case 2 -> {
                        clienteController.excluirClientePorNome();
                        clienteController.carregarClientes();
                        System.out.println("Aluno excluído com sucesso!");
                    }
                    case 3 -> {
                        System.out.println("\nAlunos cadastrados:");
                        for (Cliente aluno : clienteController.listarClientes()) {
                            System.out.println("[ID] " + aluno.getId() + "\tNOME: " + aluno.getNome() + "\tENDEREÇO: " + aluno.getEndereco() + "\tTELEFONE: " + Padronizacao.formatarTelefone(aluno.getTelefone()));
                        }
                        System.out.println("\n");
                    }
                    case 4 -> {
                        System.out.println("Finalizando...");
                        parada = true;
                        break;
                    }
                    default -> {
                        System.out.println("Opção inválida. Por favor, selecione uma das opções listadas.");
                    }
                }
            } while (!parada);
            scanner.close();
        }
    }
}
