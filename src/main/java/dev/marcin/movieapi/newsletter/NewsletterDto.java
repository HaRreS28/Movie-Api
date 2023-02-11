package dev.marcin.movieapi.newsletter;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsletterDto {
    @Email(message = "Email is not valid")
    private String mail;
}
