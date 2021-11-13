package com.purbasha.qms.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.purbasha.qms.dto.LoginDTO;
import com.purbasha.qms.dto.UserDto;
import com.purbasha.qms.errors.InternalServerErrorException;
import com.purbasha.qms.mapper.UserMapper;
import com.purbasha.qms.security.jwt.JWTFilter;
import com.purbasha.qms.security.jwt.TokenProvider;
import com.purbasha.qms.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final TokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final UserMapper userMapper;

    public AuthController(TokenProvider tokenProvider, AuthenticationManager authenticationManager
            , UserService userService,
                             UserMapper userMapper) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        boolean rememberMe = (loginDTO.getRememberMe() == null) ? false : loginDTO.getRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        UserDto account = userService.findUserByLogin()
                .map(u -> userMapper.toDto(u))
                .orElseThrow(() -> new InternalServerErrorException("User could not be found"));
        return new ResponseEntity<>(new JWTToken(jwt, account), httpHeaders, HttpStatus.OK);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;
        private UserDto account;

        JWTToken(String idToken, UserDto account) {
            this.idToken = idToken;
            this.account = account;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }

        public UserDto getAccount() {
            return account;
        }

        public void setAccount(UserDto account) {
            this.account = account;
        }
    }
}
