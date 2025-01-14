package com.tp4067.demo.controlleur;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp4067.demo.model.Users;
import com.tp4067.demo.service.UserService;



@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	// save user
	@PostMapping("/adduser")
	public List<Users> addUserController(@RequestBody Users user) {
		userService.adduser(user);
		userService.getAllUsers();
		return userService.getAllUsers();
	}

	// delete user
	@RequestMapping("/deleteuser/{id}")
	public List<Users> deleteUserController(@PathVariable("id") int id) {
		return userService.deleteUsers(id);
	}

	// get user
	@GetMapping("/getuser/{id}")
	public Users getUserController(@PathVariable("id") int id) {
		return userService.getUsers(id);
	}

	// get alluser
	@GetMapping("/getalluser")
	public List<Users> getAllUserController() {
		return userService.getAllUsers();
	}

	    // Modifier un utilisateur
    @PutMapping("/updateuser/{id}")
    public Users updateUserController(@PathVariable("id") int id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

}