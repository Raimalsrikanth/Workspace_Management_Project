package com.jsp.workspace.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.workspace.dto.Building;

public interface BuildingRepo extends JpaRepository<Building, Integer> {

	@Query("select a from Building a where a.building_Name=?1")
	public List<Building> fetchByBuildingName(String buiding_name);
	
	// @Query("select a from Building a where a.address in(select address from Address where address.city=?1)")
    // public List<Building> fetchByBuildingCity(String city_name);

	@Query("select a from Building a where a.address.city=?1")
	public List<Building> fetchByCity(String city_name);
	
	// @Query("select a from Building a where a.admin=?1")
	// public Building fetchBasedOnAddress(int id);
	
	 @Query("select a from Building a where a.admin.id=?1")
	    public List<Building> fetchBasedOnAdminId(int id);
}