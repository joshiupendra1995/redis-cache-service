package com.uj.rediscache.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6008029559929774319L;

	private String firstName;

	private String lastName;

	private String email;

	private String mobile;

}
