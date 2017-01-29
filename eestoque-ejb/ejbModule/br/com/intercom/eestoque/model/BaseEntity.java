package br.com.intercom.eestoque.model;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	abstract public Long getId();
	abstract public void setId(Long id);
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (getId() != null ? getId().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null
				|| this.getClass().getName()
						.compareTo(object.getClass().getName()) != 0) {
			return false;
		}
		BaseEntity other = (BaseEntity) object;
		if ((getId() == null && other.getId() != null)
				|| (getId() != null && !getId().equals(other.getId()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return (getId() != null ? getId().toString() : null);
	}
	
}
