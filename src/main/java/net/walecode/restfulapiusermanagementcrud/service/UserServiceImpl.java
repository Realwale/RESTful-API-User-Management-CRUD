package net.walecode.restfulapiusermanagementcrud.service;


import lombok.AllArgsConstructor;
import net.walecode.restfulapiusermanagementcrud.dto.UserDTO;
import net.walecode.restfulapiusermanagementcrud.entity.User;
import net.walecode.restfulapiusermanagementcrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
      User savedUser =  userRepository.save(user);

        return new UserDTO(savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
      userRepository.deleteById(userId);
    }

}
