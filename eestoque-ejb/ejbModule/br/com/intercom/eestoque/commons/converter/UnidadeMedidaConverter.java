package br.com.intercom.eestoque.commons.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

import br.com.intercom.eestoque.model.UnidadeMedida;
import br.com.intercom.eestoque.session.MovimentacaoItemEstoqueHome;

@Name(value = "unidadeMedidaConverter")
@BypassInterceptors
@org.jboss.seam.annotations.faces.Converter(forClass=UnidadeMedida.class)
public class UnidadeMedidaConverter implements Converter{
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		 if(arg2 == null || arg2.trim().length() == 0)
	         return null;
		MovimentacaoItemEstoqueHome movimentacaoItemEstoqueBean = (MovimentacaoItemEstoqueHome) Component.getInstance(MovimentacaoItemEstoqueHome.class);
		Long id = Long.parseLong(arg2);
		return movimentacaoItemEstoqueBean.getEntityManager().find(UnidadeMedida.class, id);
	}
	
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {	
		if (arg2 instanceof UnidadeMedida){			
			return ((UnidadeMedida)arg2).getId().toString();
		}
		return null;
	}
}
