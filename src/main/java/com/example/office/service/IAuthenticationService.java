package com.example.office.service;

import com.example.office.domain.JwtAuthenticationResponse;
import com.example.office.domain.SignInRequest;
import com.example.office.domain.SignUpRequest;

public interface IAuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signIn(SignInRequest request);
}