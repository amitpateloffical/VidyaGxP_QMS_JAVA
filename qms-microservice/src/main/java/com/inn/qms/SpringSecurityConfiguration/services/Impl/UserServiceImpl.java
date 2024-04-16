package com.inn.qms.SpringSecurityConfiguration.services.Impl;

import com.inn.qms.SpringSecurityConfiguration.Repository.UserRepository;
import com.inn.qms.SpringSecurityConfiguration.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username){
                return userRepository.findByEmail(username)
                        .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
            }
        };
    }

}
