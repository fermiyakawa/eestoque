package br.com.intercom.eestoque.session;



import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.com.intercom.eestoque.business.interfaces.ItemEstoqueServiceLocal;
import br.com.intercom.eestoque.model.ItemEstoque;


@Name("consultaSaldoItemEstoqueList")
public class ConsultaSaldoItemEstoqueList extends EntityQuery<ItemEstoque>{
   
	private static final long serialVersionUID = 1L;
		
	@In
	private ItemEstoqueServiceLocal itemEstoqueService;	
	
	@Override
	public List<ItemEstoque> getResultList() {				
		List<ItemEstoque> itens = super.getResultList();
		initSaldo(itens);
		return itens;
	}
	
	public void initSaldo(List<ItemEstoque> itens){			
		if (itens != null){
			for (ItemEstoque item : itens){				
				item.setSaldoAtual(itemEstoqueService.getSaldoAtual(item));
			}
		}
	}

	public ConsultaSaldoItemEstoqueList(){    		
        setEjbql("SELECT distinct m FROM ItemEstoque m LEFT JOIN fetch m.movimentacoes ORDER BY m.descricao asc");
    }
}
