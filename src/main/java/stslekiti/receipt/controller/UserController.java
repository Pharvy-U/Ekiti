package stslekiti.receipt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import stslekiti.receipt.payload.request.AuthenticationRequest;
import stslekiti.receipt.payload.request.CreateUserRequest;
import stslekiti.receipt.payload.response.AuthenticationResponse;
import stslekiti.receipt.payload.response.GenericResponseDTO;
import stslekiti.receipt.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody @Validated AuthenticationRequest authenticationRequest) throws Exception {
        AuthenticationResponse response = userService.authenticate(authenticationRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<GenericResponseDTO> registerUser (@RequestBody @Validated CreateUserRequest createUserRequest) throws Exception {
        System.out.println("wait");
        GenericResponseDTO responseDTO = userService.registerUser(createUserRequest);
        System.out.println("okay.................");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    public ResponseEntity<GenericResponseDTO> registerAdmin (){}

}
