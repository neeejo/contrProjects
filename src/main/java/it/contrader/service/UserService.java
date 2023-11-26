package it.contrader.service;

import it.contrader.exceptions.InvalidCredentialsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User,UserDTO> {

	public Page<User> getAllPaginata(Pageable pageable) { return ((UserRepository) repository).findAll(pageable); }

	public UserDTO findByEmailAndPassword(String username, String password) {
		return converter.toDTO(((UserRepository)repository).findByEmailAndPassword(username, password)
				.orElseThrow(() -> new InvalidCredentialsException("Credenziali Errate")));
	}

}
