package com.p5.ls.web.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.p5.ls.web.model.Section;

@Repository("sectionDao")
public interface ISectionDao extends JpaRepository<Section, Long> {
/*
	@Modifying
    @Query("UPDATE Section s SET s.sectionName = :sectionName, s.type = :type, s.details = :details WHERE s.sectionId = :sectionId")
    int update(@Param("sectionName") String sectionName, @Param("type") String type, @Param("details") String details, @Param("sectionId") Long  sectionId);
*/
}
