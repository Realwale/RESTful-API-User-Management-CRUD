package net.walecode.restfulapiusermanagementcrud.service;


import lombok.AllArgsConstructor;
import net.walecode.restfulapiusermanagementcrud.dto.UserDTO;
import net.walecode.restfulapiusermanagementcrud.entity.User;
import net.walecode.restfulapiusermanagementcrud.mapper.UserMapper;
import net.walecode.restfulapiusermanagementcrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = UserMapper.mapToUser(userDTO);

        User savedUser = userRepository.save(user);


        return UserMapper.mapToUserDTO(savedUser);

    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper:: mapToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId()).get();
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDTO(updatedUser);

    }

    @Override
    public void deleteUser(Long userId) {
      userRepository.deleteById(userId);
    }
}
