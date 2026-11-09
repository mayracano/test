package com.generic.test.respository;

import java.util.List;

import com.generic.test.model.Client;

public interface IClientRepository {
	
  public List<Client> findAll(); 
  public int  save(Client client);
  public Client findById(int id);
  public int deleteClient(int id);
  
}
