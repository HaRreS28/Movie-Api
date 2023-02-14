package dev.marcin.movieapi.web;

import dev.marcin.movieapi.newsletter.EmailVerificationService;
import dev.marcin.movieapi.newsletter.NewsletterDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/newsletter")
@RequiredArgsConstructor
public class NewsletterController {
    private final EmailVerificationService emailVerificationService;

    @PostMapping
    public ResponseEntity<?> newsletter(@Valid @RequestBody NewsletterDto newsletterDto){
        emailVerificationService.sendEmail(newsletterDto);
        return ResponseEntity.noContent().build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }
}
