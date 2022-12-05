package com.uwc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uwc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { 
	User findByUsername(String username);
	@Query("SELECT u FROM User u WHERE u.username =:keyword OR u.email =:keyword")
	public List<User> search(@Param("keyword") String keyword);
}
