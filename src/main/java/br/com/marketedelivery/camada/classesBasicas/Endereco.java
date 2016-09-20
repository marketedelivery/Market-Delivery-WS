package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco
{
	@Id
	@GeneratedValue
	private Integer codigo;

	@Column(name = "cep", length = 9, nullable = false)
	private String cep;

	@Column(name = "logradouro", length = 30, nullable = false)
	private String logradouro;

	@Column(name = "numero", nullable = false)
	private int numero;

	@Column(name = "complemento", length = 30, nullable = true)
	private String complemento;

	@Column(name = "bairro", length = 30, nullable = false)
	private String bairro;

	@Column(name = "cidade", length = 30, nullable = false)
	private String cidade;

	@Enumerated(EnumType.STRING)
	private Estado estado;

	@ManyToOne
	private Cliente cliente;

	public Endereco()
	{
		this.cep = "";
		this.logradouro = "";
		this.complemento = "";
		this.bairro = "";
		this.cidade = "";
		this.estado = null;
		this.cliente = null;
	}

	public Endereco(Integer codigo, String cep, String logradouro, int numero, String complemento, String bairro,
			String cidade, Estado estado, Cliente cliente)
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
		this.cliente = cliente;
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
	 * @return the cliente
	 */
	public Cliente getCliente()
	{
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
}