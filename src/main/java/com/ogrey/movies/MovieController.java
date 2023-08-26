package com.ogrey.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
         return new ResponseEntity<>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

    @PostMapping("/{imdbId}/delete")
    public ResponseEntity<Optional<Movie>> deleteMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.deleteMovie(imdbId), HttpStatus.OK);
    }
}
