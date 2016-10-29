package br.com.marketedelivery.camada.classesBasicas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable
{
	// Atributos
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;

	@OneToOne
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	private StatusPagamento status;

	@OneToOne
	private Pedido pedido;

	// Construtores
	public Pagamento()
	{
		super();
		this.usuario = new Usuario();
		this.pedido = new Pedido();
	}

	public Pagamento(int codigo, Usuario usuario, StatusPagamento status, Pedido pedido)
	{
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.status = status;
		this.pedido = pedido;
	}

	// gets e Sets
	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public StatusPagamento getStatus()
	{
		return status;
	}

	public void setStatus(StatusPagamento status)
	{
		this.status = status;
	}

	public Pedido getPedido()
	{
		return pedido;
	}

	public void setPedido(Pedido pedido)
	{
		this.pedido = pedido;
	}
}