/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.controller;

import com.application.academia.dao.JsonManager;
import com.application.academia.model.Funcionario;
import com.application.academia.model.Usuario.TipoUsuario;
import com.application.academia.service.Padronizacao;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author marce
 */
public class FuncinarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();
    JsonManager<Funcionario> jsonManager = new JsonManager<>();
    String filePath = "src/main/java/com/application/academia/database/funcionarios.json";

    public void carregarFuncionarios() {
        try {
            List<Funcionario> funcionariosCarregados = jsonManager.lerLista(filePath, new TypeToken<List<Funcionario>>() {
            }.getType());

            if (funcionariosCarregados != null) {
                funcionarios = funcionariosCarregados;
                System.out.println("Funcionários carregados com sucesso. Total: " + funcionarios.size());
            } else {
                funcionarios = new ArrayList<>();
                System.out.println("Nenhum funcionário encontrado. Lista inicializada vazia.");
            }
        } catch (Exception e) {
            funcionarios = new ArrayList<>();
        }
    }

    public void cadastrarFuncionario() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("Data de Nascimento (dd/MM/aaaa): ");
            String dataNascimento = scanner.nextLine();
            int idade = Padronizacao.calcularIdade(dataNascimento);
            System.out.println("Salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha pendente após nextDouble()

            System.out.println("Login: ");
            String login = scanner.nextLine();

            String senha = "";
            int tentativas = 0;
            final int MAX_TENTATIVAS = 3;

            while (tentativas < MAX_TENTATIVAS) {
                System.out.print("Senha: ");
                senha = scanner.nextLine();
                System.out.print("Confirmar senha: ");
                String confirmacao = scanner.nextLine();

                if (senha.equals(confirmacao)) {
                    break;
                } else {
                    tentativas++;
                    System.out.println("As senhas não coincidem. Você tem " + (MAX_TENTATIVAS - tentativas) + " tentativas restantes.");
                }

                if (tentativas == MAX_TENTATIVAS) {
                    System.out.println("Número máximo de tentativas atingido. Tente novamente mais tarde.");
                }
            }

            TipoUsuario tipo = TipoUsuario.FUNCIONARIO;

            Funcionario funcionario = new Funcionario(nome, dataNascimento, idade, salario, login, senha, tipo);

            funcionarios.add(funcionario);
            jsonManager.salvarLista(filePath, funcionarios);

            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    /**
     * Retorna a lista de funcionarios cadastrados.
     *
     * @return A lista de funcionarios.
     */
    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    /**
     * Edita as informações de um funcionário existente no sistema.
     *
     * Este método localiza um funcionário pelo seu login e permite que o
     * usuário atualize o nome, a data de nascimento e o salário do funcionário.
     * Se o funcionário não for encontrado, uma mensagem será exibida. O método
     * também garante que o salário inserido seja um valor numérico válido.
     *
     * @param login O login do funcionário a ser editado.
     */
    public void editarFuncionario(String login) {
        Funcionario funcionario = null;

        // Localiza o funcionário pelo login
        for (Funcionario f : funcionarios) {
            if (f.getLogin().equals(login)) {
                funcionario = f;
                break;
            }
        }

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Editar informações do funcionário: " + funcionario.getNome());

            System.out.print("Novo nome (atual: " + funcionario.getNome() + "): ");
            String novoNome = scanner.nextLine();

            System.out.print("Nova data de nascimento (atual: " + funcionario.getDataNascimento() + "): ");
            String novaDataNascimento = scanner.nextLine();

            double novoSalario = 0;
            boolean salarioValido = false;
            while (!salarioValido) {
                System.out.print("Novo salário (atual: " + funcionario.getSalario() + "): ");
                try {
                    novoSalario = scanner.nextDouble();
                    salarioValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira um valor numérico válido para o salário.");
                    scanner.next();
                }
            }

            funcionario.setNome(novoNome);
            funcionario.setDataNascimento(novaDataNascimento);
            funcionario.setSalario(novoSalario);

            jsonManager.salvarLista(filePath, funcionarios);
            System.out.println("Funcionário atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    /**
     * Exclui um funcionário da lista com base no nome informado pelo usuário.
     * Se o funcinário for encontrado, ele é removido e a lista atualizada é
     * salva no arquivo JSON.
     */
    public void excluirFuncionarioPorNome() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o nome do funcionário que deseja excluir: ");
            String nome = scanner.nextLine();

            Optional<Funcionario> funcionarioParaRemover = funcionarios.stream()
                    .filter(cliente -> cliente.getNome().equalsIgnoreCase(nome))
                    .findFirst();

            if (funcionarioParaRemover.isPresent()) {
                funcionarios.remove(funcionarioParaRemover.get());
                jsonManager.salvarLista(filePath, funcionarios);
                System.out.println("model.Funcionario '" + nome + "' foi excluido com sucesso\n");
            } else {
                System.out.println("model.Funcionario com o nome '" + nome + "' não encontrado\n");
            }
        }
    }
}
