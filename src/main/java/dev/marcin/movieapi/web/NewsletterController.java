package dev.marcin.movieapi.web;

import dev.marcin.movieapi.newsletter.EmailVerificationService;
import dev.marcin.movieapi.newsletter.NewsletterDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/newsletter")
@RequiredArgsConstructor
public class NewsletterController {
    private final EmailVerificationService emailVerificationService;

    @PostMapping
    public ResponseEntity<?> newsletter(@Valid @RequestBody NewsletterDto newsletterDto){
        emailVerificationService.sendEmail(newsletterDto);
        return ResponseEntity.accepted().build();
    }
}
