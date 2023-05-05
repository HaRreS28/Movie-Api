package dev.marcin.movieapi.user;


import dev.marcin.movieapi.config.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthDto authDto) {
        String email = authDto.getEmail();
        validate(email);
        User user = new User();
        user.setPassword(passwordEncoder.encode(authDto.getPassword()));
        user.setRole(Role.ROLE_USER);
        user.setEmail(email);
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return new AuthResponse(jwtToken, email);
    }

    private void validate(String email){
        if(userRepository.existsByEmail(email)) throw new RuntimeException("User already exist");
    }

    public AuthResponse authenticate(AuthDto authDto) {
        String email = authDto.getEmail();
        authenticationManager
                .authenticate
                        (new UsernamePasswordAuthenticationToken(email,
                                authDto.getPassword()));

        User user = userRepository.findByEmail(email).orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        return new AuthResponse(jwtToken,email);
    }
}
