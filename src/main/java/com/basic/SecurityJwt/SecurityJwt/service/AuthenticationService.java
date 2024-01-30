package com.basic.SecurityJwt.SecurityJwt.service;

import com.basic.SecurityJwt.SecurityJwt.security.auth.AuthRequest;
import com.basic.SecurityJwt.SecurityJwt.security.auth.AuthResponse;
import com.basic.SecurityJwt.SecurityJwt.model.User;
import com.basic.SecurityJwt.SecurityJwt.respository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    public AuthenticationService(JwtService jwtService, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public AuthResponse login (AuthRequest request){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword());

        authenticationManager.authenticate(authenticationToken);
        User user = userRepository.findByUsername(request.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        return new AuthResponse(jwt);
    }

    public Map<String , Object> generateExtraClaims(User user){
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());
        return extraClaims;
    }

}
