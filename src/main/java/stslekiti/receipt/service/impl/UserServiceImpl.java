package stslekiti.receipt.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import stslekiti.receipt.entity.User;
import stslekiti.receipt.payload.request.AuthenticationRequest;
import stslekiti.receipt.payload.request.CreateUserRequest;
import stslekiti.receipt.payload.response.AuthenticationResponse;
import stslekiti.receipt.payload.response.GenericResponseDTO;
import stslekiti.receipt.repository.UserRepository;
import stslekiti.receipt.service.UserService;
import stslekiti.receipt.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserCredentialsService userCredentialsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws Exception {

        AuthenticationResponse response = new AuthenticationResponse();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch(BadCredentialsException e) {
            response.setMessage("Invalid username or password");
            return response;
//            throw new Exception("Incorrect username or password", e);

        }

        final UserDetails userDetails = userCredentialsService.loadUserByUsername(authenticationRequest.getUsername());

//        AuthenticationResponse response = new AuthenticationResponse();
        response.setMessage("Successful login");
        response.setToken(jwtUtil.generateToken(userDetails));
        return response;
//        return new GenericResponseDTO("00", "Successfully authenticated", response);
    }

    @Override
    public GenericResponseDTO registerUser(CreateUserRequest createUserRequest) {
        System.out.println(createUserRequest);
        User user = new User();

//        User user = User.builder().firstName(createUserRequest.getFirstName())
//                .lastName(createUserRequest.getLastName())
//                .userName(createUserRequest.getUserName())
//                .active(createUserRequest.getActive())
//                .password(passwordEncoder.encode(createUserRequest.getPassword()))
//                .phone(createUserRequest.getPhone())
//                .email(createUserRequest.getEmail())
//                .role(createUserRequest.getRole()).build();

        BeanUtils.copyProperties(createUserRequest, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new GenericResponseDTO("00", "User saved successfully");
    }


}
