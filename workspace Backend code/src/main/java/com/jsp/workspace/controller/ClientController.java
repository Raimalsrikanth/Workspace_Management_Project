package com.jsp.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workspace.dto.Client;
import com.jsp.workspace.dto.Manager;
import com.jsp.workspace.service.ClientService;
import com.jsp.workspace.service.ManagerService;
import com.jsp.workspace.util.ResponseStructure;


@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@PostMapping("/client")
	public ResponseEntity<ResponseStructure<Client>> SaveClient(@RequestBody Client client){
		return clientService.saveClient(client);
	}
}
