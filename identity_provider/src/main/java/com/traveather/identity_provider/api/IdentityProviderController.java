package com.traveather.identity_provider.api;

import com.traveather.identity_provider.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
public class IdentityProviderController implements UserApi {

    @Override
    public ResponseEntity<User> createUser(User user) {
        return UserApi.super.createUser(user);
    }
}
