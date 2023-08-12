package com.Javaguide.springbootrestapiwithDB.services;

import com.Javaguide.springbootrestapiwithDB.Repository.UserRepository;
import com.Javaguide.springbootrestapiwithDB.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }
    @Override
    public boolean existsByCustomId(String customId) {
        System.out.println(userRepo.existsById(customId));
        return false;
    }
    @Override
    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateById(User updatedUser, String ID) {
        Optional<User> userOptional = userRepo.findById(ID);
        userOptional.ifPresent(existingUser -> {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            // Set other properties as needed

            userRepo.save(existingUser); // Save the updated user
        });
        return userRepo.findById(ID);
        }

    @Override
    public boolean deleteById(String id) {
        Optional<User> user= userRepo.findById(id);
        if(user.isPresent()) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}


