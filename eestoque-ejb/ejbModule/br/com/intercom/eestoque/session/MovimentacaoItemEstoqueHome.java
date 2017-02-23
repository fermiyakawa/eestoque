package br.com.intercom.eestoque.session;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.model.SelectItem;

import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.core.Expressions.ValueExpression;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;

import br.com.intercom.eestoque.business.impl.MovimentacaoItemEstoqueService;
import br.com.intercom.eestoque.business.interfaces.MovimentacaoItemEstoqueServiceLocal;
import br.com.intercom.eestoque.model.ItemEstoque;
import br.com.intercom.eestoque.model.MovimentacaoItemEstoque;
import br.com.intercom.eestoque.model.TipoMovimentacao;


@Name("movimentacaoItemEstoqueBean")
public class MovimentacaoItemEstoqueHome extends EntityHome<MovimentacaoItemEstoque>{
			
	private static final long serialVersionUID = 1L;
		
	@In
	private MovimentacaoItemEstoqueServiceLocal movimentacaoItemEstoqueService;
	
	@RequestParameter 
	private Long movimentacaoItemEstoqueId;
	
	@Override @Begin
    public void create() {    	 	    	
        super.create();
    }

    @Override
    public Object getId(){
        if (movimentacaoItemEstoqueId == null){
            return super.getId();
        }
        else{
            return movimentacaoItemEstoqueId;
        }
    }    
    
    @Override
    @End
    public String persist() {
    	try{
    		movimentacaoItemEstoqueService.persist(getInstance());
    	}catch(Exception e){    	
    		showMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
    		return "error";
    	}   
    	return super.persist();
    }
       
    @Override
    @End
    public String update() {
    	try{
    		movimentacaoItemEstoqueService.update(getInstance());
    	}catch(Exception e){
    		showMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
    	}  
    	return super.update();
    }
	
	public List<ItemEstoque> autoCompleteItensEstoque(Object prefix){		
		return movimentacaoItemEstoqueService.getItensEstoqueByDescricao(prefix.toString());
	}
	
	public List<SelectItem> getTiposMovimentacao(){
		List<SelectItem> tiposMovimentacaoSelect = new ArrayList<SelectItem>();
		for(TipoMovimentacao tipo : TipoMovimentacao.values()){
			tiposMovimentacaoSelect.add(new SelectItem(tipo, tipo.getDescricao()));
		}
		return tiposMovimentacaoSelect;
	}
	
	@Override		
	public ValueExpression getCreatedMessage() {		
		return createValueExpression(MovimentacaoItemEstoqueService.MSG_SUCESSO_NOVO);
	}
	
	@Override
	public ValueExpression getUpdatedMessage() {		
		return createValueExpression(MovimentacaoItemEstoqueService.MSG_SUCESSO_ALTERACAO);
	}
	
	@Override 
	public ValueExpression getDeletedMessage() {		
		return createValueExpression(MovimentacaoItemEstoqueService.MSG_SUCESSO_EXCLUSAO);
	}
	
	 private void showMessage(final Severity severity, final String message) {		 
		FacesMessages.instance().add(severity, message);		
	}
}
