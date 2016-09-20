package br.com.marketedelivery.camada.classesBasicas;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Audry Martins
 *
 */
@Entity
@Table(name = "produto")
public class Produto
{
	@Id
	@GeneratedValue
	private Integer codigo;

	@Column(name = "nome_produto", length = 50, nullable = false)
	private String nome;

	@Column(name = "descricao_produto", length = 150, nullable = false)
	private String descricao;

	@ManyToOne
	private Marca marca;

	@ManyToOne
	private UnidadeMedida unidadeMedida;

	@Column(name = "peso_produto", length = 50, nullable = false)
	private int peso;

	@Column(name = "quantidade_produto", length = 50, nullable = false)
	private int quantidade;

	@Column(name = "inf_Nutri_produto", length = 50, nullable = false)
	private String informaçãoNutricional;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_validade_produto", length = 50, nullable = false)
	private Calendar dataValidade;

	@Column(name = "preco_produto", length = 7, nullable = true)
	private double preco;

	@Enumerated
	private Status status;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Supermercado supermercado;

	// Construtores
	public Produto()
	{
		this.nome = "";
		this.descricao = "";
		this.descricao = "";
		this.marca = new Marca();
		this.unidadeMedida = new UnidadeMedida();
		this.informaçãoNutricional = "";
		this.dataValidade = Calendar.getInstance();
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
	 * @param informaçãoNutricional
	 * @param dataValidade
	 * @param status
	 * @param categoria
	 * @param supermercado
	 * @param preco
	 */
	public Produto(Integer codigo, String nome, String descricao, Marca marca, UnidadeMedida unidadeMedida, int peso,
			int quantidade, String informaçãoNutricional, Calendar dataValidade, double preco, Status status,
			Categoria categoria, Supermercado supermercado)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.unidadeMedida = unidadeMedida;
		this.peso = peso;
		this.quantidade = quantidade;
		this.informaçãoNutricional = informaçãoNutricional;
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

	public String getInformaçãoNutricional()
	{
		return informaçãoNutricional;
	}

	public void setInformaçãoNutricional(String informaçãoNutricional)
	{
		this.informaçãoNutricional = informaçãoNutricional;
	}

	public Calendar getDataValidade()
	{
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade)
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