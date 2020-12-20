package com.digito.unico.service;

import com.digito.unico.domain.User;
import com.digito.unico.exceptions.DataBaseOperationException;
import com.digito.unico.exceptions.FieldValidationException;
import com.digito.unico.exceptions.UserNotFoundException;
import com.digito.unico.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    public User save(User user, String publicKey) {
        checkRequiredsFields(user);

        try {
            user.setName(encryptionService.encrypt(user.getName(), publicKey));
            user.setEmail(encryptionService.encrypt(user.getEmail(), publicKey));
            return userRepository.save(user);
        } catch (Exception e) {
            throw new DataBaseOperationException("An error occurred while saving user.");
        }
    }

    public User update(User user, String publicKey) {
        find(user.getId());
        checkRequiredsFields(user);
        try {
            user.setName(encryptionService.encrypt(user.getName(), publicKey));
            user.setEmail(encryptionService.encrypt(user.getEmail(), publicKey));
            return userRepository.save(user);
        } catch (Exception e) {
            throw new DataBaseOperationException("An error occurred while editing user.");
        }
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

    }

    public List<User> findAll(){
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseOperationException("An error occurred getting all users.");
        }
    }

    public Boolean deleteUser(Long userId) {
        User user = find(userId);
        try {
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            throw new DataBaseOperationException("An error occurred deleting user.");
        }
    }

    public void checkUserId(Long userId) {
        if(userId != null) {
            find(userId);
        }
    }

    public User find(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new UserNotFoundException(id));
    }

    private void checkRequiredsFields(User user) {
        if(user.getName() == null || user.getName().length() == 0 ||
                user.getEmail() == null || user.getEmail().length() == 0) {
            throw new FieldValidationException("Name and e-mail are requireds fields.");
        }
    }

}
