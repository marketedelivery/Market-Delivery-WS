package br.com.marketedelivery.classesBasicas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable
{
	// atributos
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;

	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "marca", length = 50)
	private String marca;

	@Column(name = "qtdEstoque", length = 12)
	private int qtdEstoque;

	@Column(name = "valorUnitario", length = 12)
	private Double valorUnitario;

	@Column(name = "tipo", length = 50)
	private String tipo;

	@ManyToOne
	private Supermercado supermercado;

	@Column(name = "image")
	private String imagem;

	@Transient // não gera coluna, guarda informa��es temporaria
	private String caminhoImagem;

	// Construtores
	public Produto()
	{
		super();
		this.nome = "";
		this.marca = "";
		this.supermercado = new Supermercado();
		this.imagem = "";
	}

	public Produto(int codigo, String nome, String marca, int qtdEstoque, Double valorUnitario,
			Supermercado supermercado, String tipo, String imagem)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.marca = marca;
		this.qtdEstoque = qtdEstoque;
		this.valorUnitario = valorUnitario;
		this.supermercado = supermercado;
		this.tipo = tipo;
		this.imagem = imagem;
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

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getMarca()
	{
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	public int getQtdEstoque()
	{
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque)
	{
		this.qtdEstoque = qtdEstoque;
	}

	public Double getValorUnitario()
	{
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario)
	{
		this.valorUnitario = valorUnitario;
	}

	public Supermercado getSupermercado()
	{
		return supermercado;
	}

	public void setSupermercado(Supermercado supermercado)
	{
		this.supermercado = supermercado;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String getCaminhoImagem()
	{
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem)
	{
		this.caminhoImagem = caminhoImagem;
	}

	public String getImagem()
	{
		return imagem;
	}

	public void setImagem(String imagem)
	{
		this.imagem = imagem;
	}
}