package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario
{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 5)
	private Integer codigo;

	@Column(length = 40, nullable = false)
	private String email;

	@Column(length = 20, nullable = false)
	private String senha;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Enumerated(EnumType.STRING)
	private Tipo tipo_usuario;

	// Construtores
	public Usuario()
	{
		this.email = "";
		this.senha = "";
		this.status = Status.ATIVO;
		this.tipo_usuario = null;
	}

	/**
	 * @param codigo
	 * @param email
	 * @param senha
	 * @param status
	 * @param tipo_usuario
	 */
	public Usuario(Integer codigo, String email, String senha, Status status, Tipo tipo_usuario)
	{
		super();
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
		this.status = status;
		this.tipo_usuario = tipo_usuario;
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
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
	 * @return the tipo_usuario
	 */
	public Tipo getTipo_usuario()
	{
		return tipo_usuario;
	}

	/**
	 * @param tipo_usuario
	 *            the tipo_usuario to set
	 */
	public void setTipo_usuario(Tipo tipo_usuario)
	{
		this.tipo_usuario = tipo_usuario;
	}
}