package com.generic.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generic.test.model.dtos.ClientDto;
import com.generic.test.model.dtos.ServiceResponse;
import com.generic.test.service.IClientService;

@RestController
@CrossOrigin(origins = { "http://localhost:8080" })
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private IClientService clientService;
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getClients() {
    	return ResponseEntity.ok(clientService.findAll());
    	
    }

	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client")
    public ResponseEntity<ServiceResponse> saveClient(@RequestBody ClientDto client) {
    	ServiceResponse serviceReponse = new ServiceResponse();
    	int result = clientService.save(client);
    	if (result == 1) {
    		serviceReponse.setSuccess(true);
	    	serviceReponse.setMessage("Client saved with sucesss");
    	}
    	
    	return new ResponseEntity<>(serviceReponse, HttpStatus.OK);
    	
    }

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/clientes/{id}")

	public ResponseEntity<ServiceResponse> deleteClient(@PathVariable int id) {
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = 0;
			result = clientService.delete(id);
		} catch(ClientNotFoundException ex) {
			serviceReponse.setSuccess(false);
			serviceResponse.setMessage("Client with id: " + id + " Not found");
			return new ResponseEntity<>(serviceReponse, HttpStatus.NOT_FOUND);
		}
		
		if (result == 1) {
			serviceReponse.setSuccess(true);
			serviceResponse.setMessage("Client deleted with success");
		}
		return new ResponseEntity<>(serviceReponse, HttpStatus.NO_CONTENT);
	}
}
