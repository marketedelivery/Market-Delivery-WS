/**
 * 
 */
package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Marca
{
	// Atributos
	@Id
	@GeneratedValue
	private Integer codigo;

	@Column(name = "nome_marca")
	private String nome;

	// Construtores
	public Marca()
	{
		super();
		this.nome = "";
	}

	/**
	 * @param codigo
	 * @param nome
	 */
	public Marca(Integer codigo, String nome)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
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
}