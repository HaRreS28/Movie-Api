package dev.marcin.movieapi.movie;

import dev.marcin.movieapi.review.Review;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@NoArgsConstructor
@Data
public class Movie {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String imdbId;
    private String title;
    private String releaseDate;
    @Indexed(unique = true)
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;
}
