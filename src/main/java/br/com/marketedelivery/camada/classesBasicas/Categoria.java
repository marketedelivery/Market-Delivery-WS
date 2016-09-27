/**
 * 
 */
package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Categoria
{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;

	@Column(length = 20, nullable = false)
	private String subcategoria;

	@Column(length = 25, nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Status status;
	// Construtores

	public Categoria()
	{
		this.subcategoria = "";
		this.nome = "";
		this.status = Status.ATIVO;
	}

	/**
	 * @param codigo
	 * @param subcategoria
	 * @param nome
	 */
	public Categoria(Integer codigo, String subcategoria, String nome, Status status)
	{
		super();
		this.codigo = codigo;
		this.subcategoria = subcategoria;
		this.nome = nome;
		this.status = status;
	}

	// Gets e Sets
	/**
	 * @return the codigo
	 */
	public Integer getCodigo()
	{
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	/**
	 * @return the subcategoria
	 */
	public String getSubcategoria()
	{
		return subcategoria;
	}

	/**
	 * @param subcategoria
	 *            the subcategoria to set
	 */
	public void setSubcategoria(String subcategoria)
	{
		this.subcategoria = subcategoria;
	}

	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * @return the status
	 */
	public Status getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status)
	{
		this.status = status;
	}
}