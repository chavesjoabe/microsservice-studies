package com.joabechaves.hruser.services;

import com.joabechaves.hruser.entities.User;
import com.joabechaves.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return this.repository.findAll();
    }

    public User findById(Long id){
        Optional<User> userOptional = this.repository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return user;
        }
        throw new RuntimeException("Usuário nao encontrado");
    }

    public User findByEmail(String email){
        return this.repository.findByEmail(email);
    }
}
