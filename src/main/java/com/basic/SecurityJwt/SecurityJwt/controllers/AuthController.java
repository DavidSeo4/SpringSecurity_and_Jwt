package com.basic.SecurityJwt.SecurityJwt.controllers;

import com.basic.SecurityJwt.SecurityJwt.security.auth.AuthRequest;
import com.basic.SecurityJwt.SecurityJwt.security.auth.AuthResponse;
import com.basic.SecurityJwt.SecurityJwt.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> login(
            @RequestBody @Valid AuthRequest authRequest){

        AuthResponse jwtDto = authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }


}
