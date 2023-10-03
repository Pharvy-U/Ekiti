package stslekiti.receipt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import stslekiti.receipt.entity.User;
import stslekiti.receipt.repository.UserRepository;
import stslekiti.receipt.security.UserCredentialDetails;

import java.util.Optional;

@Service
public class UserCredentialsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userCredentials = userRepository.findByUserName(username);

        return userCredentials.map(UserCredentialDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
