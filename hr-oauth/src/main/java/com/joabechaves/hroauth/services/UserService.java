package com.joabechaves.hroauth.services;

import com.joabechaves.hroauth.entities.User;
import com.joabechaves.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserFeignClient userFeignClient;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("email not found "+email);
            throw new IllegalArgumentException("Email Not Found");
        }
        logger.info("found email "+email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("email not found "+email);
            throw new UsernameNotFoundException("Email Not Found");
        }
        logger.info("found email "+email);
        return user;
    }
}
