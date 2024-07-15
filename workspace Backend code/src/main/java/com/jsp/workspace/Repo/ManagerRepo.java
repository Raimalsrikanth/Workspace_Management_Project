package com.jsp.workspace.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.workspace.dto.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {

	@Query("select a from Manager a where a.experience=?1")
	public List<Manager> fetchByExp(int exp);
	
	@Query("select a from Manager a where a.name=?1")
	public List <Manager> fetchByName(String name);
}
