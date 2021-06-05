package com.evidhyalya.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evidhyalya.users.model.Role;

@Repository("roleDao")
public interface IRoleDao extends JpaRepository<Role, Long> {

}
