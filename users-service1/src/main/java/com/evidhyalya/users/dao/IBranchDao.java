package com.evidhyalya.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evidhyalya.users.model.Branch;

@Repository("branchDao")
public interface IBranchDao extends JpaRepository<Branch, Long> {

}
