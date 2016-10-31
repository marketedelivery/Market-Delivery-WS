package br.com.marketedelivery.classesBasicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable
{
	// Atrinutos
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;

	@OneToOne
	private ListaCompras lista;

	@OneToMany
	private List<Item> itens;

	// Construtores
	public Pedido()
	{
		super();
		this.lista = new ListaCompras();
		this.itens = new ArrayList<>();
	}

	public Pedido(int codigo, ListaCompras lista, List<Item> itens)
	{
		super();
		this.codigo = codigo;
		this.lista = lista;
		this.itens = itens;
	}

	// Gets e Sets
	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public ListaCompras getLista()
	{
		return lista;
	}

	public void setLista(ListaCompras lista)
	{
		this.lista = lista;
	}

	public List<Item> getItens()
	{
		return itens;
	}

	public void setItens(List<Item> itens)
	{
		this.itens = itens;
	}
}