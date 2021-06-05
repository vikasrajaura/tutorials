package com.evidhyalya.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evidhyalya.users.model.Privilege;

@Repository("privilegeDao")
public interface IPrivilegeDao extends JpaRepository<Privilege, Long> {

}
