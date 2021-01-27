package com.p5.ls.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.p5.ls.web.model.Clas;

@Service("clasService1")
public class ClasService1 extends GenericService<Clas, Long> implements IClasService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClasService1.class);
	protected Logger getLogger() {
		return logger;
	}
	
}
