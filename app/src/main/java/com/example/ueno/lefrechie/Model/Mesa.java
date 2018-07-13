package com.example.ueno.lefrechie.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ueno on 3/7/2018.
 */

public class Mesa implements Serializable {

    private int mesaId_Q;
    private int status;
    private List<Pedido> pedidos;

    public void setMesaId_Q(int mesaId_Q) {
        this.mesaId_Q = mesaId_Q;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getMesaId_Q() {
        return mesaId_Q;
    }

    public int getStatus() {
        return status;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
