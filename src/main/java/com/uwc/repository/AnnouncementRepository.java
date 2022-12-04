package com.uwc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uwc.entity.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
	@Query("SELECT a FROM Announcement a WHERE a.description = :keyword")
	public List<Announcement> search(@Param("keyword") String keyword);
}
