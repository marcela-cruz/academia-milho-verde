/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.academia.model;

import com.application.academia.controller.GeradorId;

/**
 *
 * @author marce
 */
public class Reserva {

    private String id;
    private Cliente cliente;
    private Aula aula;
    private StatusReserva status;

    public enum StatusReserva {
        AGENDAMENTO_PRELIMINAR, AGENDAMENTO_DEFINITIVO, CANCELADA, CONCLUIDA
    }

    public Reserva() {
    }

    public Reserva(String id, Cliente cliente, Aula aula, StatusReserva status) {
        this.id = GeradorId.gerarId();
        this.cliente = cliente;
        this.aula = aula;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public void confirmarReserva() {
        if (status == StatusReserva.AGENDAMENTO_PRELIMINAR) {
            status = StatusReserva.AGENDAMENTO_DEFINITIVO;
        } else {
            throw new IllegalStateException("Reserva não pode ser confirmada neste estado");
        }
    }

    public void cancelarReserva() {
        status = StatusReserva.CANCELADA;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", cliente=" + cliente + ", aula=" + aula + ", status=" + status + '}';
    }
}
