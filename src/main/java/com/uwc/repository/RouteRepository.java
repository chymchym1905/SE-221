package com.uwc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uwc.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
	@Query("SELECT r FROM Route r WHERE r.name =:keyword")
	public List<Route> search(@Param("keyword") String keyword);
}
