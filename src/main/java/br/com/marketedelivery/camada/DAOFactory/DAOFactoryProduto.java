package br.com.marketedelivery.camada.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.dados.ProdutoDAO;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;

public class DAOFactoryProduto 
{
	 
    private static EntityManagerFactory factory;
    
    public static IProdutoDAO produtoDAO;
  
    static {
        factory = Persistence.createEntityManagerFactory("bd_market");
    }
    
    public static IProdutoDAO getProdutoDAO()
    {
        produtoDAO = new ProdutoDAO(factory.createEntityManager());
        return produtoDAO;
    }

    
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    } 
}
