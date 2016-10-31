package br.com.marketedelivery.classesBasicas;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_supermercado")
public class Supermercado implements Serializable
{
	// Atributos
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;

	@Column(name = "nome")
	private String nome;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable
	private List<Produto> produtos;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	// Construtores
	public Supermercado()
	{
		this.nome = "";
		this.latitude = "";
		this.longitude = "";
	}

	public Supermercado(String nome, int codigo, List<Produto> produtos)
	{
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.produtos = produtos;
	}

	public Supermercado(String nome, List<Produto> produtos)
	{
		super();
		this.nome = nome;
		this.produtos = produtos;
	}

	// Gets e Sets
	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public List<Produto> getProdutos()
	{
		return produtos;
	}

	public void setProdutos(List<Produto> produtos)
	{
		this.produtos = produtos;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}
}