package com.p5.ls.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p5.ls.web.model.Clas;

@Repository("clasDao1")
public interface IClasDao1 extends JpaRepository<Clas, Long> {

}
