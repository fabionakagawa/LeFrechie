package com.example.ueno.lefrechie.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ueno on 3/6/2018.
 */

public class Pedido implements Serializable {

    private int PedidoId_Q;
    private int pedidoNum;
    private int mesaId_Q;
    private int balcao;
    private String Data;
    private String Hora;
    private int produtoId;
    private String produtoNome;
    private int produtoQuantidade;
    private int status;

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

    public void setHora(String hora) {
        Hora = hora;
    }

    public int getPedidoId_Q() {

        return PedidoId_Q;
    }

    public int getMesaId_Q() {
        return mesaId_Q;
    }


    public String getHora() {
        return Hora;
    }

    public int getPedidoNum() {
        return pedidoNum;
    }

    public void setPedidoNum(int pedidoNum) {
        this.pedidoNum = pedidoNum;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public int getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(int produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }
}
