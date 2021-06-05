package com.evidhyalya.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evidhyalya.users.model.Org;

@Repository("orgDao")
public interface IOrgDao extends JpaRepository<Org, Long> {

	
}
