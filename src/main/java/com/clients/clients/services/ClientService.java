/**
 * 
 */
package com.clients.clients.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clients.clients.model.Client;
import com.clients.clients.repository.ClientRepository;

/**
 * It's to define client services.
 * 
 * @author josdagaro
 *
 */
@Service
@Transactional(readOnly = true)
public class ClientService {

	/**
	 * It's a client repository.
	 * 
	 * @property ClientRepository
	 */
	private final ClientRepository repository;

	/**
	 * It builds a ClientService instance.
	 * 
	 * @param ClientRepository repository
	 * @return void
	 */
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}

	/**
	 * It finds a client by ID.
	 * 
	 * @param String id
	 * @return Client
	 */
	public Optional<Client> findById(String id) {
		return this.repository.findById(id);
	}

	/**
	 * It find clients by name.
	 * 
	 * @param name
	 * @return List<Client>
	 */
	public List<Client> findByName(String name) {
		return this.repository.findByName(name);
	}

	/**
	 * It saves a client object.
	 * 
	 * @param client
	 * @return Client
	 */
	@Transactional
	public Client save(Client client) {
		return this.repository.save(client);
	}

	/**
	 * It deletes a passed client.
	 * 
	 * @param String id
	 * @return void
	 */
	@Transactional
	public void delete(String id) {
		this.repository.deleteById(id);
	}

	/**
	 * It returns all registered clients.
	 * 
	 * @return List<Client>
	 */
	public List<Client> findAll() {
		return this.repository.findAll();
	}

}
