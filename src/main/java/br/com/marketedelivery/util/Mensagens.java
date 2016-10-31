/**
 * 
 */
package br.com.marketedelivery.util;

/**
 * @author Audry Martins
 *
 */
public class Mensagens
{
	private String msg_cliente_cadastrado_com_sucesso;

	private String msg_cliente_alterado_com_sucesso;

	private String msg_cliente_excluido_com_sucesso;

	private String msg_produto_cadastrado_com_sucesso;

	private String msg_produto_alterado_com_sucesso;

	private String msg_produto_excluido_com_sucesso;

	private String msg_perfil_cadastrado_com_sucesso;

	private String msg_perfil_alterado_com_sucesso;

	private String msg_perfil_excluido_com_sucesso;

	private String msg_categoria_cadastrada_com_sucesso;

	private String msg_categoria_alterada_com_sucesso;

	private String msg_categoria_excluida_com_sucesso;

	private String msg_marca_cadastrada_com_sucesso;

	private String msg_marca_alterada_com_sucesso;

	private String msg_marca_excluida_com_sucesso;

	private String msg_unidadeMedida_cadastrada_com_sucesso;

	private String msg_unidadeMedida_alterada_com_sucesso;

	private String msg_unidadeMedida_excluida_com_sucesso;

	private String msg_supermercado_cadastrado_com_sucesso;

	private String msg_supermercado_alterado_com_sucesso;

	private String msg_supermercado_excluido_com_sucesso;

	private String msg_usuario_cadastrado_com_sucesso;

	private String msg_usuario_alterado_com_sucesso;

	private String msg_usuario_excluido_com_sucesso;

	private String msg_senha_usuario_alterada_com_sucesso;

	private String msg_endereco_cadastrado_com_sucesso;

	private String msg_endereco_alterado_com_sucesso;

	private String msg_pedido_cadastrado_com_sucesso;

	private String msg_pedido_alterado_com_sucesso;

	private String msg_item_cadastrado_com_sucesso;

	private String msg_item_alterado_com_sucesso;

	private String msg_lista_compras_cadastrada_com_sucesso;

	private String msg_lista_compras_alterada_com_sucesso;

	private String msg_pagamento_cadastrado_com_sucesso;

	private String msg_pagamento_alterado_com_sucesso;

	private String msg_pagamento_aprovado_com_sucesso;

	private String msg_pagamento_nao_aprovado;

	// Validação de campos
	private String msg_campo_invalido;

	/**
	 * 
	 */
	public Mensagens()
	{
		super();
		this.msg_cliente_cadastrado_com_sucesso = "O cliente foi cadastrado com sucesso.";
		this.msg_cliente_alterado_com_sucesso = "O cliente foi alterado com sucesso.";
		this.msg_cliente_excluido_com_sucesso = "O cliente foi excluido com sucesso.";
		this.msg_produto_cadastrado_com_sucesso = "O produto foi cadastrado com sucesso.";
		this.msg_produto_alterado_com_sucesso = "O produto foi alterado com sucesso.";
		this.msg_produto_excluido_com_sucesso = "O produto foi excluido com sucesso.";
		this.msg_perfil_cadastrado_com_sucesso = "O perfil foi cadastrado com sucesso.";
		this.msg_perfil_alterado_com_sucesso = "O perfil foi alterado com sucesso.";
		this.msg_perfil_excluido_com_sucesso = "O perfil foi excluido com sucesso.";
		this.msg_categoria_cadastrada_com_sucesso = "A categoria foi cadastrada com sucesso.";
		this.msg_categoria_alterada_com_sucesso = "A categoria foi alterada com sucesso.";
		this.msg_categoria_excluida_com_sucesso = "A categoria foi excluida com sucesso.";
		this.msg_marca_cadastrada_com_sucesso = "A marca foi cadastrada com sucesso.";
		this.msg_marca_alterada_com_sucesso = "A marca foi alterada com sucesso.";
		this.msg_marca_excluida_com_sucesso = "A marca foi excluida com sucesso.";
		this.msg_unidadeMedida_cadastrada_com_sucesso = "A unidade de medida foi cadastrada com sucesso.";
		this.msg_unidadeMedida_alterada_com_sucesso = "A unidade de medida foi alterada com sucesso.";
		this.msg_unidadeMedida_excluida_com_sucesso = "A unidade de medida foi excluida com sucesso.";
		this.msg_supermercado_cadastrado_com_sucesso = "O supermercado foi cadastrado com sucesso.";
		this.msg_supermercado_alterado_com_sucesso = "O supermercado foi alterado com sucesso.";
		this.msg_supermercado_excluido_com_sucesso = "O supermercado foi excluido com sucesso.";
		this.msg_usuario_cadastrado_com_sucesso = "O usuario foi cadastrado com sucesso.";
		this.msg_usuario_alterado_com_sucesso = "O uusuario foi alterado com sucesso.";
		this.msg_usuario_excluido_com_sucesso = "O usuario foi excluido com sucesso.";
		this.msg_campo_invalido = "O(s) campo(s) a seguir não está(ão) preenchido(s): ";
		this.msg_senha_usuario_alterada_com_sucesso = "A senha foi alterada com sucesso.";
		this.msg_endereco_cadastrado_com_sucesso = "O Endereco foi cadastrado com sucesso.";
		this.msg_endereco_alterado_com_sucesso = "O Endereco foi alterado com sucesso.";
		this.msg_pedido_cadastrado_com_sucesso = "O Pedido foi cadastrado com sucesso.";
		this.msg_pedido_alterado_com_sucesso = "O Pedido foi alterado com sucesso.";
		this.msg_item_cadastrado_com_sucesso = "O Item foi cadastrado com sucesso.";
		this.msg_item_alterado_com_sucesso = "O Item foi alterado com sucesso.";
		this.msg_lista_compras_cadastrada_com_sucesso = "A Lista de Compras foi cadastrada com sucesso.";
		this.msg_lista_compras_alterada_com_sucesso = "A Lista de Compras foi alterada com sucesso.";
		this.msg_pagamento_cadastrado_com_sucesso = "O Pagamento foi cadastrado com sucesso.";
		this.msg_pagamento_alterado_com_sucesso = "O Pagamento foi alterado com sucesso.";
		this.msg_pagamento_aprovado_com_sucesso = "O Pagamento foi aprovado com sucesso.";
		this.msg_pagamento_nao_aprovado = "O Pagamento foi reprovado.";
	}

	/**
	 * @param msg_cliente_cadastrado_com_sucesso
	 * @param msg_cliente_alterado_com_sucesso
	 * @param msg_cliente_excluido_com_sucesso
	 * @param msg_produto_cadastrado_com_sucesso
	 * @param msg_produto_alterado_com_sucesso
	 * @param msg_produto_excluido_com_sucesso
	 * @param msg_perfil_cadastrado_com_sucesso
	 * @param msg_perfil_alterado_com_sucesso
	 * @param msg_perfil_excluido_com_sucesso
	 * @param msg_categoria_cadastrada_com_sucesso
	 * @param msg_categoria_alterada_com_sucesso
	 * @param msg_categoria_excluida_com_sucesso
	 * @param msg_marca_cadastrada_com_sucesso
	 * @param msg_marca_alterada_com_sucesso
	 * @param msg_marca_excluida_com_sucesso
	 * @param msg_unidadeMedida_cadastrada_com_sucesso
	 * @param msg_unidadeMedida_alterada_com_sucesso
	 * @param msg_unidadeMedida_excluida_com_sucesso
	 * @param msg_supermercado_cadastrado_com_sucesso
	 * @param msg_supermercado_alterado_com_sucesso
	 * @param msg_supermercado_excluido_com_sucesso
	 * @param msg_usuario_cadastrado_com_sucesso
	 * @param msg_usuario_alterado_com_sucesso
	 * @param msg_usuario_excluido_com_sucesso
	 * @param msg_senha_usuario_alterada_com_sucesso
	 * @param msg_endereco_cadastrado_com_sucesso
	 * @param msg_endereco_alterado_com_sucesso
	 * @param msg_pedido_cadastrado_com_sucesso
	 * @param msg_pedido_alterado_com_sucesso
	 * @param msg_item_cadastrado_com_sucesso
	 * @param msg_item_alterado_com_sucesso
	 * @param msg_lista_compras_cadastrada_com_sucesso
	 * @param msg_lista_compras_alterada_com_sucesso
	 * @param msg_pagamento_cadastrado_com_sucesso
	 * @param msg_pagamento_alterado_com_sucesso
	 * @param msg_pagamento_aprovado_com_sucesso
	 * @param msg_pagamento_nao_aprovado
	 * @param msg_campo_invalido
	 */
	public Mensagens(String msg_cliente_cadastrado_com_sucesso, String msg_cliente_alterado_com_sucesso,
			String msg_cliente_excluido_com_sucesso, String msg_produto_cadastrado_com_sucesso,
			String msg_produto_alterado_com_sucesso, String msg_produto_excluido_com_sucesso,
			String msg_perfil_cadastrado_com_sucesso, String msg_perfil_alterado_com_sucesso,
			String msg_perfil_excluido_com_sucesso, String msg_categoria_cadastrada_com_sucesso,
			String msg_categoria_alterada_com_sucesso, String msg_categoria_excluida_com_sucesso,
			String msg_marca_cadastrada_com_sucesso, String msg_marca_alterada_com_sucesso,
			String msg_marca_excluida_com_sucesso, String msg_unidadeMedida_cadastrada_com_sucesso,
			String msg_unidadeMedida_alterada_com_sucesso, String msg_unidadeMedida_excluida_com_sucesso,
			String msg_supermercado_cadastrado_com_sucesso, String msg_supermercado_alterado_com_sucesso,
			String msg_supermercado_excluido_com_sucesso, String msg_usuario_cadastrado_com_sucesso,
			String msg_usuario_alterado_com_sucesso, String msg_usuario_excluido_com_sucesso,
			String msg_senha_usuario_alterada_com_sucesso, String msg_endereco_cadastrado_com_sucesso,
			String msg_endereco_alterado_com_sucesso, String msg_pedido_cadastrado_com_sucesso,
			String msg_pedido_alterado_com_sucesso, String msg_item_cadastrado_com_sucesso,
			String msg_item_alterado_com_sucesso, String msg_lista_compras_cadastrada_com_sucesso,
			String msg_lista_compras_alterada_com_sucesso, String msg_pagamento_cadastrado_com_sucesso,
			String msg_pagamento_alterado_com_sucesso, String msg_pagamento_aprovado_com_sucesso,
			String msg_pagamento_nao_aprovado, String msg_campo_invalido)
	{
		super();
		this.msg_cliente_cadastrado_com_sucesso = msg_cliente_cadastrado_com_sucesso;
		this.msg_cliente_alterado_com_sucesso = msg_cliente_alterado_com_sucesso;
		this.msg_cliente_excluido_com_sucesso = msg_cliente_excluido_com_sucesso;
		this.msg_produto_cadastrado_com_sucesso = msg_produto_cadastrado_com_sucesso;
		this.msg_produto_alterado_com_sucesso = msg_produto_alterado_com_sucesso;
		this.msg_produto_excluido_com_sucesso = msg_produto_excluido_com_sucesso;
		this.msg_perfil_cadastrado_com_sucesso = msg_perfil_cadastrado_com_sucesso;
		this.msg_perfil_alterado_com_sucesso = msg_perfil_alterado_com_sucesso;
		this.msg_perfil_excluido_com_sucesso = msg_perfil_excluido_com_sucesso;
		this.msg_categoria_cadastrada_com_sucesso = msg_categoria_cadastrada_com_sucesso;
		this.msg_categoria_alterada_com_sucesso = msg_categoria_alterada_com_sucesso;
		this.msg_categoria_excluida_com_sucesso = msg_categoria_excluida_com_sucesso;
		this.msg_marca_cadastrada_com_sucesso = msg_marca_cadastrada_com_sucesso;
		this.msg_marca_alterada_com_sucesso = msg_marca_alterada_com_sucesso;
		this.msg_marca_excluida_com_sucesso = msg_marca_excluida_com_sucesso;
		this.msg_unidadeMedida_cadastrada_com_sucesso = msg_unidadeMedida_cadastrada_com_sucesso;
		this.msg_unidadeMedida_alterada_com_sucesso = msg_unidadeMedida_alterada_com_sucesso;
		this.msg_unidadeMedida_excluida_com_sucesso = msg_unidadeMedida_excluida_com_sucesso;
		this.msg_supermercado_cadastrado_com_sucesso = msg_supermercado_cadastrado_com_sucesso;
		this.msg_supermercado_alterado_com_sucesso = msg_supermercado_alterado_com_sucesso;
		this.msg_supermercado_excluido_com_sucesso = msg_supermercado_excluido_com_sucesso;
		this.msg_usuario_cadastrado_com_sucesso = msg_usuario_cadastrado_com_sucesso;
		this.msg_usuario_alterado_com_sucesso = msg_usuario_alterado_com_sucesso;
		this.msg_usuario_excluido_com_sucesso = msg_usuario_excluido_com_sucesso;
		this.msg_senha_usuario_alterada_com_sucesso = msg_senha_usuario_alterada_com_sucesso;
		this.msg_endereco_cadastrado_com_sucesso = msg_endereco_cadastrado_com_sucesso;
		this.msg_endereco_alterado_com_sucesso = msg_endereco_alterado_com_sucesso;
		this.msg_pedido_cadastrado_com_sucesso = msg_pedido_cadastrado_com_sucesso;
		this.msg_pedido_alterado_com_sucesso = msg_pedido_alterado_com_sucesso;
		this.msg_item_cadastrado_com_sucesso = msg_item_cadastrado_com_sucesso;
		this.msg_item_alterado_com_sucesso = msg_item_alterado_com_sucesso;
		this.msg_lista_compras_cadastrada_com_sucesso = msg_lista_compras_cadastrada_com_sucesso;
		this.msg_lista_compras_alterada_com_sucesso = msg_lista_compras_alterada_com_sucesso;
		this.msg_pagamento_cadastrado_com_sucesso = msg_pagamento_cadastrado_com_sucesso;
		this.msg_pagamento_alterado_com_sucesso = msg_pagamento_alterado_com_sucesso;
		this.msg_pagamento_aprovado_com_sucesso = msg_pagamento_aprovado_com_sucesso;
		this.msg_pagamento_nao_aprovado = msg_pagamento_nao_aprovado;
		this.msg_campo_invalido = msg_campo_invalido;
	}

	// Gets e Sets
	/**
	 * @return the msg_cliente_cadastrado_com_sucesso
	 */
	public String getMsg_cliente_cadastrado_com_sucesso()
	{
		return msg_cliente_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_cliente_alterado_com_sucesso
	 */
	public String getMsg_cliente_alterado_com_sucesso()
	{
		return msg_cliente_alterado_com_sucesso;
	}

	/**
	 * @return the msg_cliente_excluido_com_sucesso
	 */
	public String getMsg_cliente_excluido_com_sucesso()
	{
		return msg_cliente_excluido_com_sucesso;
	}

	/**
	 * @return the msg_produto_cadastrado_com_sucesso
	 */
	public String getMsg_produto_cadastrado_com_sucesso()
	{
		return msg_produto_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_produto_alterado_com_sucesso
	 */
	public String getMsg_produto_alterado_com_sucesso()
	{
		return msg_produto_alterado_com_sucesso;
	}

	/**
	 * @return the msg_produto_excluido_com_sucesso
	 */
	public String getMsg_produto_excluido_com_sucesso()
	{
		return msg_produto_excluido_com_sucesso;
	}

	/**
	 * @return the msg_perfil_cadastrado_com_sucesso
	 */
	public String getMsg_perfil_cadastrado_com_sucesso()
	{
		return msg_perfil_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_perfil_alterado_com_sucesso
	 */
	public String getMsg_perfil_alterado_com_sucesso()
	{
		return msg_perfil_alterado_com_sucesso;
	}

	/**
	 * @return the msg_perfil_excluido_com_sucesso
	 */
	public String getMsg_perfil_excluido_com_sucesso()
	{
		return msg_perfil_excluido_com_sucesso;
	}

	/**
	 * @return the msg_categoria_cadastrada_com_sucesso
	 */
	public String getMsg_categoria_cadastrada_com_sucesso()
	{
		return msg_categoria_cadastrada_com_sucesso;
	}

	/**
	 * @return the msg_categoria_alterada_com_sucesso
	 */
	public String getMsg_categoria_alterada_com_sucesso()
	{
		return msg_categoria_alterada_com_sucesso;
	}

	/**
	 * @return the msg_categoria_excluida_com_sucesso
	 */
	public String getMsg_categoria_excluida_com_sucesso()
	{
		return msg_categoria_excluida_com_sucesso;
	}

	/**
	 * @return the msg_marca_cadastrada_com_sucesso
	 */
	public String getMsg_marca_cadastrada_com_sucesso()
	{
		return msg_marca_cadastrada_com_sucesso;
	}

	/**
	 * @return the msg_marca_alterada_com_sucesso
	 */
	public String getMsg_marca_alterada_com_sucesso()
	{
		return msg_marca_alterada_com_sucesso;
	}

	/**
	 * @return the msg_marca_excluida_com_sucesso
	 */
	public String getMsg_marca_excluida_com_sucesso()
	{
		return msg_marca_excluida_com_sucesso;
	}

	/**
	 * @return the msg_unidadeMedida_cadastrada_com_sucesso
	 */
	public String getMsg_unidadeMedida_cadastrada_com_sucesso()
	{
		return msg_unidadeMedida_cadastrada_com_sucesso;
	}

	/**
	 * @return the msg_unidadeMedida_alterada_com_sucesso
	 */
	public String getMsg_unidadeMedida_alterada_com_sucesso()
	{
		return msg_unidadeMedida_alterada_com_sucesso;
	}

	/**
	 * @return the msg_unidadeMedida_excluida_com_sucesso
	 */
	public String getMsg_unidadeMedida_excluida_com_sucesso()
	{
		return msg_unidadeMedida_excluida_com_sucesso;
	}

	/**
	 * @return the msg_supermercado_cadastrado_com_sucesso
	 */
	public String getMsg_supermercado_cadastrado_com_sucesso()
	{
		return msg_supermercado_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_supermercado_alterado_com_sucesso
	 */
	public String getMsg_supermercado_alterado_com_sucesso()
	{
		return msg_supermercado_alterado_com_sucesso;
	}

	/**
	 * @return the msg_supermercado_excluido_com_sucesso
	 */
	public String getMsg_supermercado_excluido_com_sucesso()
	{
		return msg_supermercado_excluido_com_sucesso;
	}

	/**
	 * @return the msg_usuario_cadastrado_com_sucesso
	 */
	public String getMsg_usuario_cadastrado_com_sucesso()
	{
		return msg_usuario_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_uauario_alterado_com_sucesso
	 */
	public String getMsg_usuario_alterado_com_sucesso()
	{
		return msg_usuario_alterado_com_sucesso;
	}

	/**
	 * @return the msg_usuario_excluido_com_sucesso
	 */
	public String getMsg_usuario_excluido_com_sucesso()
	{
		return msg_usuario_excluido_com_sucesso;
	}

	/**
	 * @return the msg_campo_invalido
	 */
	public String getMsg_campo_invalido()
	{
		return msg_campo_invalido;
	}

	/**
	 * @return the msg_senha_usuario_alterada_com_sucesso
	 */
	public String getMsg_senha_usuario_alterada_com_sucesso()
	{
		return msg_senha_usuario_alterada_com_sucesso;
	}

	/**
	 * @return the msg_endereco_cadastrado_com_sucesso
	 */
	public String getMsg_endereco_cadastrado_com_sucesso()
	{
		return msg_endereco_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_endereco_alterado_com_sucesso
	 */
	public String getMsg_endereco_alterado_com_sucesso()
	{
		return msg_endereco_alterado_com_sucesso;
	}

	/**
	 * @return the msg_pedido_cadastrado_com_sucesso
	 */
	public String getMsg_pedido_cadastrado_com_sucesso()
	{
		return msg_pedido_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_pedido_alterado_com_sucesso
	 */
	public String getMsg_pedido_alterado_com_sucesso()
	{
		return msg_pedido_alterado_com_sucesso;
	}

	/**
	 * @return the msg_item_cadastrado_com_sucesso
	 */
	public String getMsg_item_cadastrado_com_sucesso()
	{
		return msg_item_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_item_alterado_com_sucesso
	 */
	public String getMsg_item_alterado_com_sucesso()
	{
		return msg_item_alterado_com_sucesso;
	}

	/**
	 * @return the msg_lista_compras_cadastrada_com_sucesso
	 */
	public String getMsg_lista_compras_cadastrada_com_sucesso()
	{
		return msg_lista_compras_cadastrada_com_sucesso;
	}

	/**
	 * @return the msg_lista_compras_alterada_com_sucesso
	 */
	public String getMsg_lista_compras_alterada_com_sucesso()
	{
		return msg_lista_compras_alterada_com_sucesso;
	}

	/**
	 * @return the msg_pagamento_cadastrado_com_sucesso
	 */
	public String getMsg_pagamento_cadastrado_com_sucesso()
	{
		return msg_pagamento_cadastrado_com_sucesso;
	}

	/**
	 * @return the msg_pagamento_alterado_com_sucesso
	 */
	public String getMsg_pagamento_alterado_com_sucesso()
	{
		return msg_pagamento_alterado_com_sucesso;
	}

	/**
	 * @return the msg_pagamento_aprovado_com_sucesso
	 */
	public String getMsg_pagamento_aprovado_com_sucesso()
	{
		return msg_pagamento_aprovado_com_sucesso;
	}

	/**
	 * @return the msg_pagamento_nao_aprovado
	 */
	public String getMsg_pagamento_nao_aprovado()
	{
		return msg_pagamento_nao_aprovado;
	}
}