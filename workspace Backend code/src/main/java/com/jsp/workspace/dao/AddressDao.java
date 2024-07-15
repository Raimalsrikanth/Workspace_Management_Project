package com.jsp.workspace.dao;

import org.springframework.stereotype.Repository;

import com.jsp.workspace.Repo.AddressRepo;
import com.jsp.workspace.dto.Address;

@Repository
public class AddressDao {
	
private AddressRepo addressRepo; 
	
	public Address updateAddress(Address a,Address b) {
		if(a.getCity()!=b.getCity() &&b.getCity()!=null) {
			a.setCity(b.getCity());
		}
		else {
			a.setCity(a.getCity());
		}
		if(a.getDistrict() !=b.getDistrict() && b.getDistrict() !=null) {
			a.setDistrict(b.getDistrict());
		}
		else {
			a.setDistrict(a.getDistrict());
		}
		if(a.getDoor_No() !=b.getDoor_No() && b.getDoor_No() !=null) {
			a.setDoor_No(b.getDoor_No());
		}
		else {
			a.setDoor_No(a.getDoor_No());
		}
		if(a.getLandmark() !=b.getLandmark() && b.getLandmark() !=null) {
			a.setLandmark(a.getLandmark());
		}
		else {
			a.setLandmark(a.getLandmark());
		}
		if(a.getPincode() !=b.getPincode() && b.getPincode() !=0) {
			a.setPincode(b.getPincode());
		}
		else {
			a.setPincode(a.getPincode());
		}
		if(a.getStreet() !=b.getStreet() && b.getStreet() !=null) {
			a.setStreet(b.getStreet());
		}
		else {
			a.setStreet(a.getStreet());
		}
		if(a.getState() !=b.getState() && b.getState() !=null) {
			a.setState(b.getState());
		}
		else {
			a.setState(a.getState());
		}
		return a;
	}
}

