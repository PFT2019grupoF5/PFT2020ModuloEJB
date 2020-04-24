package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.RenglonPedido;
import com.exception.ServiciosException;

@Remote
public interface IRenglonPedidosRemote {

	public void addRenglonPedido(RenglonPedido renglonPedido) throws ServiciosException;
	public List<RenglonPedido> getAllRenglonPedidos() throws ServiciosException;
	public RenglonPedido getRenglonPedido(Long id) throws ServiciosException;
	public void removeRenglonPedido(Long id) throws ServiciosException;
	public void updateRenglonPedido(RenglonPedido renglonPedido) throws ServiciosException;
	
}