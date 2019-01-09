/**
 * 
 */
package com.clients.clients.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * It represents the table clients from database.
 * 
 * @author josdagaro
 *
 */
@Data
@Entity
@Table(name = "clients")
public class Client {

	/**
	 * It's the client's database UID.
	 * 
	 * @property String
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

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
