package br.com.marketedelivery.classesBasicas;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable
{
	// Atributos
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "nome", length = 30)
	private String nome;

	@Column(name = "CPF", length = 14)
	private String cpf;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private Endereco endereco;

	@Column(name = "telefoneWhatsapp", length = 16)
	private String telefoneWhatsapp;

	@Enumerated(EnumType.STRING)
	@Fetch(FetchMode.JOIN)
	private Perfil perfil;

	@Column(name = "Telefone", length = 15)
	private String telefone;

	@Column(name = "Email", length = 30)
	private String email;

	@Column(name = "Senha", length = 10)
	private String senha;
	
	@Column(name = "codigoFacebook")
	private String codigoFacebook;

	// Construtores
	public Usuario()
	{
		super();
		this.nome = "";
		this.cpf = "";
		this.endereco = new Endereco();
		this.telefoneWhatsapp = "";
		this.telefone = "";
		this.perfil = Perfil.Usuário;
		this.email = "";
		this.senha = "";
		this.codigoFacebook ="";
	}

	public Usuario(Integer codigo, String nome, String cpf, Endereco endereco, String telefoneWhatsapp, String telefone,
			Perfil perfil, String email, String senha, String codigoFacebook)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefoneWhatsapp = telefoneWhatsapp;
		this.telefone = telefone;
		this.perfil = perfil;
		this.email = email;
		this.senha = senha;
		this.codigoFacebook = codigoFacebook;
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

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public Endereco getEndereco()
	{
		return endereco;
	}

	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}

	public String getTelefoneWhatsapp()
	{
		return telefoneWhatsapp;
	}

	public void setTelefoneWhatsapp(String telefoneWhatsapp)
	{
		this.telefoneWhatsapp = telefoneWhatsapp;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public Perfil getPerfil()
	{
		return perfil;
	}

	public void setPerfil(Perfil perfil)
	{
		this.perfil = perfil;
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
	
	public String getCodigoFacebook()
	{
		return codigoFacebook;
	}
	 void setCodigoFacebook(String codigoFacebook)
	{
		this.codigoFacebook = codigoFacebook;
	}
}