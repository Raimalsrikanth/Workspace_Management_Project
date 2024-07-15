package com.jsp.workspace.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.jsp.workspace.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandlerForWorkspace {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlExceptionHandler(SQLIntegrityConstraintViolationException e) {
		
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(e.getMessage());
		structure.setMessage("You Cannot perform this operation");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
				
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> adminIdNotFound(AdminIdNotFound e){
			
	   	 ResponseStructure<String> structure = new ResponseStructure<String>();
	   	 structure.setData(e.getMessage());
	   	 structure.setMessage("Admin id not found");
	   	 structure.setStatus(HttpStatus.NOT_FOUND.value());
	   	 
	   	 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
		
	@ExceptionHandler(BuildingNotFoundBasedOnName.class)
	public ResponseEntity<ResponseStructure<String>> buildingNotFoundBasedOnName(BuildingNotFoundBasedOnName e){
			
	   	 ResponseStructure<String> structure = new ResponseStructure<String>();
	   	 structure.setData(e.getMessage());
	   	 structure.setMessage("building name not found");
	   	 structure.setStatus(HttpStatus.NOT_FOUND.value());
	   	 
	   	 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
		
	@ExceptionHandler(BuildingNotFoundBasedOnCityName.class)
	public ResponseEntity<ResponseStructure<String>> buildingNotFoundBasedOnCityName(BuildingNotFoundBasedOnCityName e){
			
	   	 ResponseStructure<String> structure = new ResponseStructure<String>();
	   	 structure.setData(e.getMessage());
	   	 structure.setMessage("City name not found");
	   	 structure.setStatus(HttpStatus.NOT_FOUND.value());
	   	 
	   	 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BuildingNotFoundBasedOnId.class)
	public ResponseEntity<ResponseStructure<String>> BuildingNotFoundBasedOnId(BuildingNotFoundBasedOnId e){
			
	   	 ResponseStructure<String> structure = new ResponseStructure<String>();
	   	 structure.setData(e.getMessage());
	   	 structure.setMessage("building id not found");
	   	 structure.setStatus(HttpStatus.NOT_FOUND.value());
	   	 
	   	 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ManagerNotFoundBasedOnId.class)
	public ResponseEntity<ResponseStructure<String>> managerIdNotFound(BuildingNotFoundBasedOnId e){
			
	   	 ResponseStructure<String> structure = new ResponseStructure<String>();
	   	 structure.setData(e.getMessage());
	   	 structure.setMessage("Manager id not found");
	   	 structure.setStatus(HttpStatus.NOT_FOUND.value());
	   	 
	   	 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BuildingAssignManager.class)
	public ResponseEntity<ResponseStructure<String>> buildingAssignManager(BuildingAssignManager e) {
			
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(e.getMessage());
		structure.setMessage("Manager already assigned");
		structure.setStatus(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.ACCEPTED);
	}	
		
}
