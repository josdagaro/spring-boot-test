/**
 * 
 */
package com.clients.clients.resources.schemas;

import lombok.Data;

/**
 * @author josdagaro
 *
 */
@Data
public class ClientSchema {

	/**
	 * It's the client's first name.
	 * 
	 * @property String
	 */
	private String name;

	/**
	 * it's the client's last name.
	 * 
	 * @property String
	 */
	private String lastName;
}
