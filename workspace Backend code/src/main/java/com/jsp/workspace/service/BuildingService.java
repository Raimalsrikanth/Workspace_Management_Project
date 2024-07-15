package com.jsp.workspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.workspace.dao.AdminDao;
import com.jsp.workspace.dao.BuildingDao;
import com.jsp.workspace.dao.ManagerDao;
import com.jsp.workspace.dto.Admin;
import com.jsp.workspace.dto.Building;
import com.jsp.workspace.dto.Manager;
import com.jsp.workspace.exception.AdminIdNotFound;
import com.jsp.workspace.exception.BuildingAssignManager;
import com.jsp.workspace.exception.BuildingNotFoundBasedOnCityName;
import com.jsp.workspace.exception.BuildingNotFoundBasedOnId;
import com.jsp.workspace.exception.BuildingNotFoundBasedOnName;
import com.jsp.workspace.exception.ManagerNotFoundBasedOnId;
import com.jsp.workspace.util.ResponseStructure;

@Service
public class BuildingService {
	
	@Autowired
	private BuildingDao buildingDao;

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private ManagerDao managerDao;
	
	/*
	 *  Saving Building Object if Admin is present
	 */
	public ResponseEntity<ResponseStructure<Building>> saveBuilding(Building building, int admin_id) {
		Admin db = adminDao.fetchAdminById(admin_id);
		if (db != null) {
			building.setAdmin(db);
			ResponseStructure<Building> structure = new ResponseStructure<Building>();
			structure.setData(buildingDao.saveBuilding(building));
			structure.setMessage("building save successfully...");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.CREATED);
		} else {
			throw new AdminIdNotFound(admin_id + "  admin id is not present");
		}

	}
	
	//Fetching Building Based On Building Id
		public ResponseEntity<ResponseStructure<Building>> fetchBasedOnId(int id){
			Building db=buildingDao.fetchBasedOnId(id);
			if(db!=null){
				ResponseStructure<Building> structure = new ResponseStructure<Building>();
				structure.setData(db);
				structure.setMessage("Building Found With The Id "+id);
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<Building>>(structure,HttpStatus.FOUND);
				
			}
			else{
				 throw new BuildingNotFoundBasedOnId("Building Not Found With The id "+id);
			}
			
		}
	
	/*
	 *  fetching All buildings
	 */
	public ResponseEntity<ResponseStructure<List<Building>>>fetchAll() {
		List<Building> db = buildingDao.fetchAll();
		if (db != null) {
			ResponseStructure<List<Building>> structure = new ResponseStructure<List<Building>>();
			structure.setData(db);
			structure.setMessage("All buildings are found");
			structure.setStatus(HttpStatus.FOUND.value());
		
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);
		} else {
			//throw new BuildingNotFoundBasedOnName("Buildings are  not present");
		}
		return null;
	}

	
	/*
	 *  Fetching Building Object Based On Building Name
	 */
	public ResponseEntity<ResponseStructure<List<Building>>> fetchBuildingByName(String building_name) {
		List<Building> db = buildingDao.fetchBasedOnName(building_name);
		if (db != null) {
			ResponseStructure<List<Building>> structure = new ResponseStructure<List<Building>>();
			structure.setData(db);
			structure.setMessage(building_name + " found");
			structure.setStatus(HttpStatus.FOUND.value());
		
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);
		} else {
			throw new BuildingNotFoundBasedOnName(building_name + "  not present");
		}

	}
	
	/*
	 *  Fetching Building Object Based On Building City
	 */
	public ResponseEntity<ResponseStructure<List<Building>>> fetchBuildingByCity(String city_name) {
		List<Building> db = buildingDao.fetchBasedOnCity(city_name);
		if (db != null) {
			ResponseStructure<List<Building>> structure = new ResponseStructure<List<Building>>();
			structure.setData(db);
			structure.setMessage(city_name + " found");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);
		} else {
			throw new BuildingNotFoundBasedOnCityName(city_name + "  not present");
		}

	}
	
	//Assigning Manager To Building IF Admin And Building And Building Manager Is Null
		public ResponseEntity<ResponseStructure<Building>> assignManager(int admin_id,int building_id,int manager_id){
			Admin admin=adminDao.fetchAdminById(admin_id);
			if(admin!=null) {
				Building building=buildingDao.fetchBasedOnId(building_id);
					if(building !=null) {
						Manager managerId= managerDao.fetchManagerById(manager_id);
						
						if(managerId !=null) {
							if(building.getManager() ==null) {
								building.setManager(managerId);
								Building bul=buildingDao.saveBuilding(building);
								ResponseStructure<Building> structure = new ResponseStructure<Building>();
								structure.setData(bul);
	  							structure.setMessage("Manager Assigned  successfully....");
								structure.setStatus(HttpStatus.CREATED.value());
								return new ResponseEntity<ResponseStructure<Building>>(structure,HttpStatus.CREATED);
							}
							else {
								throw new BuildingAssignManager("Manager Allredy Assigned For the Building "+manager_id);
							}
						}
						else {
							throw new BuildingAssignManager("Manager Not Found With Id "+manager_id+" Unable To Assign Manager To Building");
						}
					}
					else {
						throw new BuildingNotFoundBasedOnId("Building Not Found "+building_id+" Unable To Assign Manager To Building");
					}
				}
			else {
				throw new AdminIdNotFound("Admin Not Found "+admin_id+" Unable To Assign Manager To Building");
			}
		}
		
		
		//**********Updating The Building Details***********//
		public ResponseEntity<ResponseStructure<Building>> updatingBuilding(Building building ){
			Building buld=buildingDao.updatingBuilding(building);
			if(buld!=null) {
				ResponseStructure<Building> structure = new ResponseStructure<Building>();
				structure.setData(buld);
				structure.setMessage("Building Updation Is Sucessfull");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Building>>(structure,HttpStatus.OK);
				
			}
			else {
				throw new BuildingNotFoundBasedOnId("Building Id "+building.getId()+" Is Not Found So Updating Building Is Not Posssible");
			}
		}
		
		
		//**********Deleting Building Object *********//
		public ResponseEntity<ResponseStructure<Building>> deleteBuilding(int id){
			Building b=buildingDao.deleteBuilding(id);
			if(b!=null) {
				ResponseStructure<Building> structure = new ResponseStructure<Building>();
				structure.setData(b);
				structure.setMessage("Building Deleting Is Sucessfull");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Building>>(structure,HttpStatus.OK);
			}
			else {
				throw new BuildingNotFoundBasedOnId("Building Not Found With Given Id "+id);
			}
		}
		

}
	
	
	
	

	