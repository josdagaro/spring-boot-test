/**
 * 
 */
package com.clients.clients.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clients.clients.model.Client;
import com.clients.clients.resources.schemas.ClientSchema;
import com.clients.clients.services.ClientService;

/**
 * It's the exposed end point web clients are going to request.
 * 
 * @author josdagaro
 *
 */
@RestController
@RequestMapping("/api/clients")
public class ClientResource {

	/**
	 * It's the defined client service.
	 * 
	 * @property ClientService
	 */
	private final ClientService service;

	/**
	 * It builds a ClientResource instance.
	 * 
	 * @param ClientService service
	 * @return void
	 */
	public ClientResource(ClientService service) {
		this.service = service;
	}

	@GetMapping("/health")
	public String health() {
		return "OK";
	}

	/**
	 * It's an end point to create a new client.
	 * 
	 * @param ClientSchema clientSchema
	 * @return ResponseEntity<Client>
	 */
	@PostMapping
	public ResponseEntity<Client> create(@RequestBody ClientSchema clientSchema) {
		Client client = new Client();
		client.setName(clientSchema.getName());
		client.setLastName(clientSchema.getLastName());
		return new ResponseEntity<>(this.service.save(client), HttpStatus.CREATED);
	}

	/**
	 * It's an end point to delete an existent client.
	 * 
	 * @param String id
	 * @return void
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		Optional<Client> client = this.service.findById(id);
		if (client.isPresent()) {
			this.service.delete(client.get().getId());
		}
	}

	/**
	 * It returns all registered clients.
	 * 
	 * @return ResponseEntity<List<Client>>
	 */
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

}
