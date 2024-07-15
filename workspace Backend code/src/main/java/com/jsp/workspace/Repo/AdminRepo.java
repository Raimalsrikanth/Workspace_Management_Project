package com.jsp.workspace.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.workspace.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	@Query("select a from Admin a where a.name=?1")
	public List<Admin> findByAdminName(String name);
}
