package net.walecode.restfulapiusermanagementcrud.service;


import net.walecode.restfulapiusermanagementcrud.dto.UserDTO;
import net.walecode.restfulapiusermanagementcrud.entity.User;

import java.util.List;

public interface UserService {


    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(Long userId);
}
