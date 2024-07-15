package com.jsp.workspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workspace.dao.AdminDao;
import com.jsp.workspace.dao.BuildingDao;
import com.jsp.workspace.dto.Building;
import com.jsp.workspace.service.BuildingService;
import com.jsp.workspace.util.ResponseStructure;

@RestController
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;

	@Autowired
	private BuildingDao buildingDao;

	@PostMapping("/Savebuilding")
	public ResponseEntity<ResponseStructure<Building>> saveBuilding(@RequestBody Building building,@RequestParam int admin_id) {
		return buildingService.saveBuilding(building, admin_id);
	}
	
	@GetMapping("/fetchBuildingId")
	public ResponseEntity<ResponseStructure<Building>> fetchById(@RequestParam int id){
		return buildingService.fetchBasedOnId(id);
	}

	@GetMapping("/fetchBuildingName")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchByBuildingName(@RequestParam String building_name) {
		return buildingService.fetchBuildingByName(building_name);
	}
	
	@GetMapping("/fetch All buildings")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchAll() {
		return buildingService.fetchAll();
	}

	@GetMapping("/fetch_building_city")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchBuildingByCity(@RequestParam String city_name) {
		System.out.println(city_name);
		return buildingService.fetchBuildingByCity(city_name);
	}
	
	/*
	 *  To Assign Manager with building we take three variables
	 *  To check whether the admin,manager & building is present or not
	 */
	@PutMapping("/assignManagerToBuilding")
	public ResponseEntity<ResponseStructure<Building>> assignManager(@RequestParam int admin_id, @RequestParam int manager_id, @RequestParam int building_id) {
		return buildingService.assignManager(admin_id, manager_id, building_id);
	}
		
	
	@PutMapping("/updatingBuilding")
	public ResponseEntity<ResponseStructure<Building>> updatingBuilding(@RequestBody Building building){
		return buildingService.updatingBuilding(building);
	}
	
	
	@DeleteMapping("/deletingBuilding")
	public ResponseEntity<ResponseStructure<Building>> deletingBuilding(@RequestParam int id){
		return buildingService.deleteBuilding(id);
	}
}
