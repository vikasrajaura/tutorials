package com.p5.ls.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.p5.ls.web.model.Clas;
 
@Repository("clasDao")
public class ClasDao extends GenericDao<Clas, Long> implements IClasDao{
 
	private static final Logger LOGGER = LoggerFactory.getLogger(ClasDao.class);

	protected Logger getLogger() {
		return LOGGER;
	}

	protected String getIdName() {
		return "clasId";
	}
}