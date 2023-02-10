package dev.marcin.movieapi.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReviewDto {
    private String body;
    private String movieImdb;

    public ReviewDto(String body) {
        this.body = body;
    }
}
