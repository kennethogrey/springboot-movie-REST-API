package com.ogrey.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public Optional<Movie> deleteMovie(String imdbId) {
        Optional<Movie> movie = movieRepository.findMovieByImdbId(imdbId);

        if (movie.isPresent()) {
            List<Review> reviews = movie.get().getReviewIds();
            reviewRepository.deleteAll(reviews);
            return movieRepository.deleteMovieByImdbId(imdbId);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Movie> updateMovie(String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> genres, List<String> backdrops){
        Optional<Movie> movie = movieRepository.findMovieByImdbId(imdbId);
        if (movie.isPresent()){

        }

        return Optional.empty();
    }
}
