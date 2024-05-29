package se.inyat.myenterpriseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.inyat.myenterpriseapp.model.User;
import se.inyat.myenterpriseapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User user) {
        return userRepository.findById(id).map(existingUser -> {
            //existingUser.setName(user.getName());
            //existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        });
    }

    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
