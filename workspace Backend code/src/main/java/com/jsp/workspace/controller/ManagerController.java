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

import com.jsp.workspace.dto.Manager;
import com.jsp.workspace.service.ManagerService;
import com.jsp.workspace.util.ResponseStructure;

@RestController
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;

	@PostMapping("/SavingManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager){
		return managerService.saveManager(manager);
	}
	
	@GetMapping("/fetchManagerBasedOnId")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerBasedOnId(@RequestParam int id){
		return managerService.fetchBasedOnId(id);
	}
	
	@GetMapping("/fetchAllManagers")
	public ResponseEntity<ResponseStructure<List<Manager>>> fetchManager() {
		return managerService.fetchManager();
	}
	
	@GetMapping("/fetchManagerByExp")
	public ResponseEntity<ResponseStructure<List<Manager>>> fetchByExp(@RequestParam int exp){
		return managerService.fetchManagerByExp(exp);
	}
	
	@GetMapping("/fetchManagerByName")
	public ResponseEntity<ResponseStructure<List<Manager>>> fetchManagerByName(@RequestParam String name){
		return managerService.fetchManagerByName(name);
	}
	
	@PutMapping("/updatingManager")
	public ResponseEntity<ResponseStructure<Manager>> updateDetails(@RequestBody Manager manager){
		return managerService.updateManager(manager);
	}
	
	@DeleteMapping("/deletingManager")
	public ResponseEntity<ResponseStructure<List<Manager>>> deleteManager(@RequestParam int id){
		return managerService.fetchManagerByExp(id);
	}
}