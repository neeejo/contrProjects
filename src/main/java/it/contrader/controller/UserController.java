package it.contrader.controller;

import it.contrader.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserDTO> {

	@Autowired
	private UserService userService;

	@GetMapping("getAllPaginata")
	public ResponseEntity<Page<User>> getall(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber ) {
		return new ResponseEntity<>(userService.getAllPaginata(PageRequest.of(pageNumber, pageSize)), HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> login(@RequestBody @Valid LoginDTO loginDTO) {
		return new ResponseEntity<>(userService.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()), HttpStatus.OK);
	}
	@PostMapping(value = "/registrazione")
	public ResponseEntity<UserDTO> registrazione(@RequestBody @Valid UserDTO userDTO) {
		return new ResponseEntity<>(userService.insert(userDTO), HttpStatus.OK);
	}




}