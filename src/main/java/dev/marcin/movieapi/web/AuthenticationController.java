package dev.marcin.movieapi.web;

import dev.marcin.movieapi.user.AuthDto;
import dev.marcin.movieapi.user.AuthResponse;
import dev.marcin.movieapi.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody AuthDto authDto){
        return ResponseEntity.ok( userService.register(authDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody AuthDto authDto){
        return ResponseEntity.ok( userService.authenticate(authDto));
    }


}
