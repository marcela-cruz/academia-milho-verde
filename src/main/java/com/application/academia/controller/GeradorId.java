/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.controller;

import java.util.UUID;

/**
 * Esta classe é responsável por gerar IDs únicos.
 *
 * @author marce
 */
public class GeradorId {

    /**
     * Gera um ID aleatório extraindo um número específico de dígitos
     * de um UUID (Identificador Único Universal) gerado aleatoriamente.
     *
     * @return Uma string contendo os dígitos extraídos do UUID.
     */
    public static String gerarId(){
        String uuid = UUID.randomUUID().toString();
        StringBuilder numerous = new StringBuilder();

        int contador = 0;
        int limit = 10;

        for (char c : uuid.toCharArray()) {
            if (Character.isDigit(c)) {
                if (contador < limit) {
                    numerous.append(c);
                    contador++;
                }
            }
        }

        return numerous.toString();
    }

    /**
     * Retorna uma representação em string do objeto GeradorId.
     *
     * @return Uma string representando o estado do GeradorId.
     */
    @Override
    public String toString() {
        return "GeradorId{" + '}';
    }
}
