package dev.marcin.movieapi.review;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReviewDto {
    private String body;
    private String movieImdb;
    private String author;

    public ReviewDto(String body, String author) {
        this.body = body;
        this.author = author;
    }
}
