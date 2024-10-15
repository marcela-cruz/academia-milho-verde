/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.controller;

import com.application.academia.dao.JsonManager;
import com.application.academia.model.Cliente;
import com.application.academia.model.Endereco;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Classe responsável pelo controle das operações relacionadas aos clientes,
 * incluindo cadastro, exclusão e listagem.
 *
 * @author marce
 */
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();
    JsonManager<Cliente> jsonManager = new JsonManager<>();
    String filePath = "src/main/java/com/application/academia/database/clientes.json";

    /**
     * Construtor da classe ClienteController.
     */
    public ClienteController() {

    }

    /**
     * Carrega a lista de clientes a partir de um arquivo JSON. Se a leitura
     * falhar, a lista de clientes é inicializada como vazia.
     */
    public void carregarClientes() {
        List<Cliente> clientesCarregados = jsonManager.lerLista(filePath, new TypeToken<List<Cliente>>() {
        }.getType());
        if (clientesCarregados != null) {
            clientes = clientesCarregados;
        } else {
            clientes = new ArrayList<>();
        }
    }

    /**
     * Cadastra um novo cliente, solicitando informações ao usuário, e salva a
     * lista atualizada no arquivo JSON.
     */
    public void cadastrarCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
            String nomeCliente, enderecoCliente, telefoneCliente, emailCliente, cpfCliente;

            System.out.println("Nome: ");
            nomeCliente = scanner.nextLine();
            System.out.println("Telefone: ");
            telefoneCliente = scanner.nextLine();
            System.out.println("E-mail: ");
            emailCliente = scanner.nextLine();
            System.out.println("CPF: ");
            cpfCliente = scanner.nextLine();
            System.out.println("Endereço (Formato: Rua, Número, Bairro, Cidade): ");
            enderecoCliente = scanner.nextLine();

            String[] enderecoPartes = enderecoCliente.split(",");

            if (enderecoPartes.length == 4) {
                String ruaCliente = enderecoPartes[0].trim();
                String numeroCliente = enderecoPartes[1].trim();
                String bairroCliente = enderecoPartes[2].trim();
                String cidadeCliente = enderecoPartes[3].trim();

                Endereco enderecoClienteCompleto = new Endereco(ruaCliente, numeroCliente, bairroCliente, cidadeCliente);
                Cliente clienteCadastrado = new Cliente(nomeCliente, enderecoClienteCompleto, telefoneCliente, emailCliente, cpfCliente);

                clientes.add(clienteCadastrado);
                jsonManager.salvarLista(filePath, clientes);
                System.out.println("Cliente cadastrado com sucesso!");
            } else {
                System.out.println("Erro: O endereço deve conter Rua, Número, Cidade, Estado e CEP, separados por vírgulas.");
            }
        }
    }

    /**
     * Exclui um cliente da lista com base no nome informado pelo usuário. Se o
     * cliente for encontrado, ele é removido e a lista atualizada é salva no
     * arquivo JSON.
     */
    public void excluirClientePorNome() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o nome do cliente que deseja excluir: ");
            String nome = scanner.nextLine();

            Optional<Cliente> clienteParaRemover = clientes.stream()
                    .filter(cliente -> cliente.getNome().equalsIgnoreCase(nome))
                    .findFirst();

            if (clienteParaRemover.isPresent()) {
                clientes.remove(clienteParaRemover.get());
                jsonManager.salvarLista(filePath, clientes);
                System.out.println("model.Cliente '" + nome + "' foi excluido com sucesso\n");
            } else {
                System.out.println("model.Cliente com o nome '" + nome + "' não encontrado\n");
            }
        }
    }

    /**
     * Método para excluir um cliente com base no ID. (Implementação ainda não
     * concluída.)
     */
    public void excluirClienteById() {

    }

    /**
     * Retorna a lista de clientes cadastrados.
     *
     * @return A lista de clientes.
     */
    public List<Cliente> listarClientes() {
        return clientes;
    }

    /**
     * Retorna uma representação em string do objeto ClienteController.
     *
     * @return Uma string representando o estado do ClienteController.
     */
    @Override
    public String toString() {
        return "ClienteController{" + "clientes=" + clientes + ", jsonManager=" + jsonManager + ", filePath=" + filePath + '}';
    }
}
