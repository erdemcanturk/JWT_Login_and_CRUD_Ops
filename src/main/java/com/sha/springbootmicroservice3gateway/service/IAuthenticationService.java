package com.sha.springbootmicroservice3gateway.service;

import com.sha.springbootmicroservice3gateway.model.User;


public interface IAuthenticationService
{
    String signInAndReturnJWT(User signInRequest);
}
