package stslekiti.receipt.service;

import stslekiti.receipt.payload.request.AuthenticationRequest;
import stslekiti.receipt.payload.request.CreateUserRequest;
import stslekiti.receipt.payload.response.AuthenticationResponse;
import stslekiti.receipt.payload.response.GenericResponseDTO;

public interface UserService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws Exception;

    GenericResponseDTO registerUser(CreateUserRequest createUserRequest);
}
