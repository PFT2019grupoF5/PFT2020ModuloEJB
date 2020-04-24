package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.Pedido;
import com.exception.ServiciosException;

@Remote
public interface IPedidosRemote {

	public void addPedido(Pedido pedido) throws ServiciosException;
	public List<Pedido> getAllPedidos() throws ServiciosException;
	public Pedido getPedido(Long id) throws ServiciosException;
	public void removePedido(Long id) throws ServiciosException;
	public void updatePedido(Pedido pedido) throws ServiciosException;
	
}