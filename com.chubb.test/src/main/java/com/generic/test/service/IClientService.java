package com.generic.test.service;

import java.util.List;
import com.generic.test.model.dtos.ClientDto;

public interface IClientService {
	public List<ClientDto> findAll();
	 public int  save(ClientDto client);
	 public void delete(ClientDto client);
}
