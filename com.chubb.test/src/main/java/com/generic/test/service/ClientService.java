package com.generic.test.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generic.test.model.Client;
import com.generic.test.model.dtos.ClientDto;
import com.generic.test.respository.IClientRepository;


@Service
public class ClientService implements IClientService {

	@Autowired
	private IClientRepository clientRepository;
	

	 
	@Override
	public List<ClientDto> findAll() {
		List<ClientDto> clients = new ArrayList<ClientDto>();
		
		try {
			clientRepository.findAll().forEach((c) -> {
				//convert  this to auto mapped
				ClientDto cl = new ClientDto(c.getId(), c.getFirstName(), c.getLastName(), c.getSurname(), c.getPhone());
				clients.add(cl);
			});
        
		}catch(Exception ex){
			throw ex;
		}
		
		return clients;
	}



	@Override
	public int save(ClientDto clientdto) {
		int row = 0;
		try {
			
			Client client = new Client();
			
			//convert  this to auto mapped
			
			client.setFirstName(clientdto.getFirstName());
			client.setLastName(clientdto.getLastName());
			client.setSurname(clientdto.getSurname());
			client.setPhone(clientdto.getPhone());
			
			row = clientRepository.save(client);
        
		}catch(Exception ex){
			throw ex;
		}
		
		return row;
	}

	@Override
	public void delete(ClientDto client) {
		Client client = clientRepository.findById(client.getId());
		if (cliente == null) {
			throw new ClientNotFoundException("Client does not exists on the database")
		}
		clientRespository.delete(client.getId());
	}

}
