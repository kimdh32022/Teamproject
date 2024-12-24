package service;

import dto.UsersDTO;

import java.util.Optional;

public interface UsersService {
    UsersDTO createUser(UsersDTO userDTO);
    Optional<UsersDTO> getUserById(Long userId);
}
