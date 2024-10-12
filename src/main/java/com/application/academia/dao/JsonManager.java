/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.dao;

import com.google.gson.Gson;

import java.util.List;
import java.io.*;
import java.lang.reflect.Type;

/**
 * Classe responsável pela gestão de operações de leitura e escrita de objetos em arquivos JSON.
 *
 * @param <T> O tipo genérico que será manipulado pela classe.
 * @author marce
 */
public class JsonManager<T> {

    private final Gson gson = new Gson();

    /**
     * Lê um único objeto de um arquivo JSON.
     *
     * @param filePath O caminho do arquivo JSON a ser lido.
     * @param tClass A classe do objeto a ser lido.
     * @return O objeto lido do arquivo JSON ou null se ocorrer um erro de leitura.
     * @throws RuntimeException Se o arquivo não for encontrado.
     */
    public T lerObjeto(String filePath, Class<T> tClass){
        try (FileReader reader = new FileReader(filePath)){
           return gson.fromJson(reader, tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lê uma lista de objetos de um arquivo JSON.
     *
     * @param filePath O caminho do arquivo JSON a ser lido.
     * @param typeOft O tipo da lista a ser lida, utilizando a reflexão.
     * @return A lista de objetos lida do arquivo JSON ou null se ocorrer um erro de leitura.
     * @throws RuntimeException Se o arquivo não for encontrado.
     */
    public List<T> lerLista(String filePath, Type typeOft){
        try (FileReader reader = new FileReader(filePath)){
            return gson.fromJson(reader, typeOft);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Salva um objeto em um arquivo JSON.
     *
     * @param filePath O caminho do arquivo onde o objeto será salvo.
     * @param objeto O objeto a ser salvo no arquivo JSON.
     */
    public void salvarObjeto(String filePath, T objeto){
        try(FileWriter writer = new FileWriter(filePath)){
            gson.toJson(objeto,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Salva uma lista de objetos em um arquivo JSON.
     *
     * @param filePath O caminho do arquivo onde a lista será salva.
     * @param lista A lista de objetos a ser salva no arquivo JSON.
     */
    public void salvarLista(String filePath, List<T> lista){
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma representação em string do objeto JsonManager.
     *
     * @return Uma string representando o estado do JsonManager.
     */
    @Override
    public String toString() {
        return "JsonManager{" + "gson=" + gson + '}';
    }
}
