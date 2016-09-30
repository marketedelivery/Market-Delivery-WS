package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;

	@Column(length = 9, nullable = false)
	private String cep;

	@Column(length = 30, nullable = false)
	private String logradouro;

	@Column(length = 5, nullable = false)
	private int numero;

	@Column(length = 30, nullable = true)
	private String complemento;

	@Column(length = 30, nullable = false)
	private String bairro;

	@Column(length = 30, nullable = false)
	private String cidade;

	@Enumerated(EnumType.STRING)
	@Column(length = 2, nullable = false)
	private Estado estado;

	@Enumerated(EnumType.STRING)
	private Status status;

	public Endereco()
	{
		this.cep = "";
		this.logradouro = "";
		this.complemento = "";
		this.bairro = "";
		this.cidade = "";
		this.estado = null;
		this.status = Status.ATIVO;
	}

	public Endereco(Integer codigo, String cep, String logradouro, int numero, String complemento, String bairro,
			String cidade, Estado estado, Status status)
	{
		super();
		this.codigo = codigo;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.status = status;
	}

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

	public String getCep()
	{
		return cep;
	}

	public void setCep(String cep)
	{
		this.cep = cep;
	}

	public String getLogradouro()
	{
		return logradouro;
	}

	public void setLogradouro(String logradouro)
	{
		this.logradouro = logradouro;
	}

	public int getNumero()
	{
		return numero;
	}

	public void setNumero(int numero)
	{
		this.numero = numero;
	}

	public String getComplemento()
	{
		return complemento;
	}

	public void setComplemento(String complemento)
	{
		this.complemento = complemento;
	}

	public String getBairro()
	{
		return bairro;
	}

	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}

	public String getCidade()
	{
		return cidade;
	}

	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public Estado getEstado()
	{
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(Estado estado)
	{
		this.estado = estado;
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