package com.jsp.workspace.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workspace.dto.Address;
import com.jsp.workspace.dto.Admin;
import com.jsp.workspace.dto.Building;
import com.jsp.workspace.Repo.BuildingRepo;

@Repository
public class BuildingDao {
	
	@Autowired
	private BuildingRepo buildingRepo;
	
	@Autowired
	private AddressDao addressdao;
	
	/////Saving The Building Object
	public Building saveBuilding(Building building) {
		return buildingRepo.save(building);
	}

	//**********Fetching Building Based On Building Name *******// 
	public List<Building> fetchBasedOnName(String name) {
		List<Building> list = buildingRepo.fetchByBuildingName(name);
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}
	
	//fetching Buildings
	public List<Building> fetchAll() {
		List<Building> list = buildingRepo.findAll();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	//**********Fetching Building Based On BuildingCity *******// 
	public List<Building> fetchBasedOnCity(String city_name) {
		List<Building> list = buildingRepo.fetchByCity(city_name);
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	//**********Fetching Building Based On BuildingID *******// 
	public Building fetchBasedOnId(int id) {
		Optional<Building> optional = buildingRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	/*
	 *  This method is used to assign manager to the building
	 */
	public Building updateBuilding(Building dbbuilding) {
		Optional<Building> dbbuild = buildingRepo.findById(dbbuilding.getId());
		if (dbbuild.isPresent()) {
			return buildingRepo.save(dbbuilding);
		} else {
			return null;
		}

	}
	
	
	// UpDating The Building Object/////////////////////////
		public Building updatingBuilding(Building building) {
			Optional<Building> opt = buildingRepo.findById(building.getId());
			if(opt.isPresent()) {
				Building bul=opt.get();
				if(bul.getBuilding_Name()!=building.getBuilding_Name() && building.getBuilding_Name()!=null) {
					bul.setBuilding_Name(building.getBuilding_Name());
				}
				else {
					bul.setBuilding_Name(bul.getBuilding_Name());
				}
				if(bul.getRatings() !=building.getRatings() && building.getRatings()!=0) {
					bul.setRatings(building.getRatings());
				}
				else {
					bul.setRatings(bul.getRatings());
				}
				if(building.getAddress()!=null) {
					Address a=addressdao.updateAddress(bul.getAddress(),building.getAddress());
					bul.setAddress(a);
				}
				return buildingRepo.save(bul); 
			}
			else {
				return null;
			}
		}
		
		
	//************Deleting Building Object *****************//	
		public Building deleteBuilding(int id) {
			Optional<Building> b=buildingRepo.findById(id);
			if(b.isPresent()) {
				Building b1=b.get();
				buildingRepo.delete(b1);
				return b1;
			}
			else {
				return null;
			}
		}
		
		public List<Building> fetchBuildingsByAdminId(int id){
			List<Building> lis=buildingRepo.fetchBasedOnAdminId(id);
			if(lis.size()!=0) {
				return lis;
			}
			else {
				return null;
			}
		}
		
		
		public void deleteListOfBuildings(List<Building> building) {
			buildingRepo.deleteAll(building);
		}

}
