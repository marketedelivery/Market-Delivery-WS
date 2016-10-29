package br.com.marketedelivery.camada.classesBasicas;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item")
public class Item implements Serializable
{
	// Atributos
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;

	@OneToOne
	private Produto produto;

	@Column(name = "precoTotal", length = 12)
	private Double precoTotal;

	@Column(name = "qtdProduto", length = 12)
	private int qtdProduto;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private ListaCompras lista;

	// Construtores
	public Item()
	{
		super();
		this.produto = new Produto();
		this.lista = new ListaCompras();
	}

	public Item(int codigo, Produto produto, Double precoTotal, int qtdProduto, ListaCompras lista)
	{
		super();
		this.codigo = codigo;
		this.produto = produto;
		this.precoTotal = precoTotal;
		this.qtdProduto = qtdProduto;
		this.lista = lista;
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

	public Produto getProduto()
	{
		return produto;
	}

	public void setProduto(Produto produto)
	{
		this.produto = produto;
	}

	public Double getPrecoTotal()
	{
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal)
	{
		this.precoTotal = precoTotal;
	}

	public int getQtdProduto()
	{
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto)
	{
		this.qtdProduto = qtdProduto;
	}

	public ListaCompras getLista()
	{
		return lista;
	}

	public void setLista(ListaCompras lista)
	{
		this.lista = lista;
	}
}