package br.com.intercom.eestoque.business.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class BaseService {
	
	@PersistenceContext(unitName="eestoque", type=PersistenceContextType.TRANSACTION)
	protected EntityManager em;
}
