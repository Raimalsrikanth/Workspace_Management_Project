package com.jsp.workspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workspace.dao.ClientDao;
import com.jsp.workspace.dto.Client;
import com.jsp.workspace.util.ResponseStructure;


@Service
public class ClientService {
	
	@Autowired
	private ClientDao clientDao;

	public ResponseEntity<ResponseStructure<Client>> saveClient(Client client) {
		
		Client dbclient = clientDao.saveClient(client);
		
		ResponseStructure<Client> structure = new ResponseStructure<Client>();
		structure.setData(dbclient);
		structure.setMessage("client save successfully...");
		structure.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Client>>(structure, HttpStatus.CREATED);
	}
}
