package com.p5.ls.web.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional(value = "jpaTxMgr", readOnly = false)
public abstract class JpaGenericService<T, ID extends Serializable> implements IJpaGenericService<T, ID> {

	private final Class<T> clazz;
	private final Logger logger;
	
	protected abstract Logger getLogger();

	@SuppressWarnings("unchecked")
	public JpaGenericService() {
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		this.logger = getLogger();
	}



}