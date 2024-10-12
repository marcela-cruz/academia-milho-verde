/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.controller;

import java.util.UUID;

/**
 *
 * @author marce
 */
public class GeradorId {

    /**
     *
     * @return
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
}
