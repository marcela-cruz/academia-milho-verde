/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.service;

/**
 * Classe responsável pela padronização de dados, como CPF e telefone.
 * 
 * @author marce
 */
public class Padronizacao {

    /**
     * Anonimiza um CPF, ocultando os três primeiros dígitos e os dois últimos.
     *
     * @param cpf O CPF a ser anonimizado. Deve conter exatamente 11 dígitos.
     * @return O CPF anonimizado no formato "***.XXX.***-**", onde "XXX" representa os dígitos do CPF.
     * @throws IllegalArgumentException Se o CPF não tiver 11 dígitos.
     */
    public static String anonimizarCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        return "***." + cpf.substring(3, 6) + ".***-**";
    }

    /**
     * Formata um CPF no padrão "XXX.XXX.XXX-XX".
     *
     * @param cpf O CPF a ser formatado. Deve conter exatamente 11 dígitos.
     * @return O CPF formatado no padrão "XXX.XXX.XXX-XX".
     * @throws IllegalArgumentException Se o CPF não tiver 11 dígitos.
     */
    public static String formatarCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    /**
     * Formata um número de telefone no padrão "(XX) XXXXX-XXXX".
     *
     * @param telefone O telefone a ser formatado. Deve conter exatamente 11 dígitos.
     * @return O telefone formatado no padrão "(XX) XXXXX-XXXX".
     * @throws IllegalArgumentException Se o telefone não tiver 11 dígitos.
     */
    public static String formatarTelefone(String telefone) {
        if (telefone.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
    }

    /**
     * Retorna uma representação em string do objeto Padronizacao.
     *
     * @return Uma string representando o estado do Padronizacao.
     */
    @Override
    public String toString() {
        return "Padronizacao{" + '}';
    }
}
