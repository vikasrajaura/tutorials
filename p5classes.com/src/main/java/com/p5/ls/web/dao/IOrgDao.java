package com.p5.ls.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p5.ls.web.model.Org;

@Repository("orgDao")
public interface IOrgDao extends JpaRepository<Org, Long> {

}
