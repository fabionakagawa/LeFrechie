package com.example.ueno.lefrechie.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ueno on 3/6/2018.
 */

public class Pedido implements Serializable {

    private int PedidoId_Q;
    private int mesaId_Q;
    private int balcao;
    private String Data;
    private String Hora;
    private ListaProdutos listaProdutos;
    private int status;
    private int totalPedido;

    public int getBalcao() {
        return balcao;
    }

    public void setBalcao(int balcao) {
        this.balcao = balcao;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setPedidoId_Q(int pedidoId_Q) {
        PedidoId_Q = pedidoId_Q;
    }

    public void setMesaId_Q(int mesaId_Q) {
        this.mesaId_Q = mesaId_Q;
    }

    public void setData(String data) {
        Data = data;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public void setTotalPedido(int totalPedido) {
        this.totalPedido = totalPedido;
    }

    public int getPedidoId_Q() {

        return PedidoId_Q;
    }

    public int getMesaId_Q() {
        return mesaId_Q;
    }

    public String getData() {
        return Data;
    }

    public String getHora() {
        return Hora;
    }

    public int getTotalPedido() {
        return totalPedido;
    }

    public ListaProdutos getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ListaProdutos listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
