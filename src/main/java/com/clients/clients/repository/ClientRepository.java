/**
 * 
 */
package com.clients.clients.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clients.clients.model.Client;

/**
 * It's to define operations about database clients.
 * 
 * @author josdagaro
 *
 */
public interface ClientRepository extends JpaRepository<Client, String> {

	/**
	 * It's a function to find a client by name.
	 * 
	 * @param String name
	 * @return List<Client>
	 */
	public List<Client> findByName(String name);

	/**
	 * It's a function to find a client by ID.
	 * 
	 * @param String id
	 * @return Client
	 */
	public Optional<Client> findById(String id);
}
