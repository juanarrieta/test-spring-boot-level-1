package coop.tecso.examen.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.User;
import coop.tecso.examen.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

	private UserService userService;
	
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		return userService.findAll();
	}
}
