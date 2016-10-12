/*package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Perfil;

@Path("/service")
public class ControladorPerfil
{
	private IPerfilDAO perfilDAO;

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPerfil")
	public void CadastrarPerfil(Perfil perfil)
	{
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		perfilDAO.inserir(perfil);
	}
	
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarPerfil")
	public void AtualizarPerfil(Perfil perfil)
	{
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		perfilDAO.alterar(perfil);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosPerfil")
	public List<Perfil> ListarTodosPerfil()
	{
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		return perfilDAO.consultarTodos();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPorCodigo")
	public Perfil PesquisarPorCodigo(Perfil perfil)
	{
		int codigo = perfil.getCodigo();
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		Perfil retorno = perfilDAO.consultarPorId(codigo);
		return retorno;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPorNome")
	public Perfil PesquisarPorNome(Perfil perfil)
	{
		String nome = perfil.getNome();
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		Perfil retorno = perfilDAO.BuscarPorNome(nome);
		return retorno;
	}
}*/