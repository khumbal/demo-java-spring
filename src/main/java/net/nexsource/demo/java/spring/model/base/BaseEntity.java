package net.nexsource.demo.java.spring.model.base;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.core.convert.converter.Converter;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6131624397726154435L;
	private Long id;
	private Date createdOn = new Date();

	public BaseEntity(){

	}

	public BaseEntity(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Date getCreatedOn(){
		return createdOn;
	}

	public void setCreatedOn(Date createdOn){
		this.createdOn = createdOn;
	}

	public boolean equals(Object object){
		if(object == null){
			return false;
		}
		if(!BaseEntity.class.isAssignableFrom(object.getClass())){
			return false;
		}
		if(getId() == null && ((BaseEntity) object).getId() == null){
			return this == object;
		}
		return new EqualsBuilder().append(getId(), ((BaseEntity) object).getId()).isEquals();
	}

}
