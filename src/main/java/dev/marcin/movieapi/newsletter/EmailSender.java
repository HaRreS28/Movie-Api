package dev.marcin.movieapi.newsletter;

public interface EmailSender {
 void sendEmail(NewsletterDto newsletterDto);
}