package br.com.intercom.eestoque.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.com.intercom.eestoque.model.MovimentacaoItemEstoque;

@Name("movimentacaoItemEstoqueList")
public class MovimentacaoItemEstoqueList extends EntityQuery<MovimentacaoItemEstoque>{
   
	private static final long serialVersionUID = 1L;

	public MovimentacaoItemEstoqueList(){    
        setEjbql("SELECT m FROM MovimentacaoItemEstoque m");
    }
}
