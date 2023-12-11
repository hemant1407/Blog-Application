package com.firstSpringProject.Blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	
	private int id;
	
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	private String about;
	
}
