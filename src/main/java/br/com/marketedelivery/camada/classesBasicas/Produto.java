package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Produto
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;

	@Column(name = "nome_produto", length = 50, nullable = false)
	private String nome;

	@Column(name = "descricao_produto", length = 150, nullable = false)
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Marca marca;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	private UnidadeMedida unidadeMedida;

	@Column(length = 50, nullable = false)
	private int peso;

	@Column(length = 50, nullable = false)
	private int quantidade;

	@Column(length = 20, nullable = false)
	private String dataValidade;

	@Column(length = 7, nullable = true)
	private double preco;

	@Enumerated(EnumType.STRING)
	@Column(length = 15, nullable = false)
	private Status status;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(updatable = true)
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Supermercado supermercado;

	// Construtores
	public Produto()
	{
		this.nome = "";
		this.descricao = "";
		this.descricao = "";
		this.marca = new Marca();
		this.unidadeMedida = new UnidadeMedida();
		this.dataValidade = "";
		this.status = Status.ATIVO;
		this.categoria = new Categoria();
		this.supermercado = new Supermercado();
	}

	/**
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @param marca
	 * @param unidadeMedida
	 * @param peso
	 * @param quantidade
	 * @param dataValidade
	 * @param status
	 * @param categoria
	 * @param supermercado
	 * @param preco
	 */
	public Produto(Integer codigo, String nome, String descricao, Marca marca, UnidadeMedida unidadeMedida, int peso,
			int quantidade, String dataValidade, double preco, Status status, Categoria categoria,
			Supermercado supermercado)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.unidadeMedida = unidadeMedida;
		this.peso = peso;
		this.quantidade = quantidade;
		this.dataValidade = dataValidade;
		this.preco = preco;
		this.status = status;
		this.categoria = categoria;
		this.supermercado = supermercado;
	}

	// Gets e Sets
	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
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

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public Marca getMarca()
	{
		return marca;
	}

	public void setMarca(Marca marca)
	{
		this.marca = marca;
	}

	public UnidadeMedida getUnidadeMedida()
	{
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida)
	{
		this.unidadeMedida = unidadeMedida;
	}

	public int getPeso()
	{
		return peso;
	}

	public void setPeso(int peso)
	{
		this.peso = peso;
	}

	public int getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(int quantidade)
	{
		this.quantidade = quantidade;
	}

	public String getDataValidade()
	{
		return dataValidade;
	}

	public void setDataValidade(String dataValidade)
	{
		this.dataValidade = dataValidade;
	}

	/**
	 * @return the preco
	 */
	public double getPreco()
	{
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(double preco)
	{
		this.preco = preco;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria()
	{
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}

	/**
	 * @return the supermercado
	 */
	public Supermercado getSupermercado()
	{
		return supermercado;
	}

	/**
	 * @param supermercado
	 *            the supermercado to set
	 */
	public void setSupermercado(Supermercado supermercado)
	{
		this.supermercado = supermercado;
	}
}