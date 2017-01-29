package br.com.intercom.eestoque.session;

import javax.annotation.PostConstruct;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.com.intercom.eestoque.business.impl.ItemEstoqueService;
import br.com.intercom.eestoque.business.interfaces.ItemEstoqueServiceLocal;
import br.com.intercom.eestoque.model.ItemEstoque;


@Name("consultaSaldoItemEstoqueList")
public class ConsultaSaldoItemEstoqueList extends EntityQuery<ItemEstoque>{
   
	private static final long serialVersionUID = 1L;
		
	private ItemEstoqueServiceLocal itemEstoqueService;
	
	@PostConstruct
	public void initSaldo(){		
		if (getResultList() != null){
			for (ItemEstoque item : getResultList()){				
				item.setSaldoAtual(itemEstoqueService.getSaldoAtual(item));
			}
		}
	}

	public ConsultaSaldoItemEstoqueList(){    
		this.itemEstoqueService = new ItemEstoqueService(getEntityManager());
        setEjbql("SELECT distinct m FROM ItemEstoque m LEFT JOIN fetch m.movimentacoes ORDER BY m.descricao asc");
    }
}
