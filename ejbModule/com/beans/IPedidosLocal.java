package com.beans;

import java.util.List;
import javax.ejb.Local;

import com.entities.Pedido;
import com.exception.ServiciosException;

@Local
public interface IPedidosLocal {

	public void addPedido(Pedido pedido) throws ServiciosException;
	public List<Pedido> getAllPedidos() throws ServiciosException;
	public Pedido getPedido(Long id) throws ServiciosException;
	public void removePedido(Long id) throws ServiciosException;
	public void updatePedido(Pedido pedido) throws ServiciosException;
	
	public List<Pedido> getPedidosEntreFechas(String fechaDesde, String fechaHasta) throws ServiciosException;
	
}