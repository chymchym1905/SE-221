package com.uwc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uwc.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	@Query("SELECT t FROM Task t WHERE t.id =:keyword")
	public List<Task> search(@Param("keyword") String keyword);
}
