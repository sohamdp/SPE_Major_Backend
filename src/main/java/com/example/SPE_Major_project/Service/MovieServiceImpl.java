package com.example.SPE_Major_project.Service;

import com.example.SPE_Major_project.Entity.Movie;
import com.example.SPE_Major_project.Entity.Reviews;
import com.example.SPE_Major_project.Repository.MovieRepository;
import com.example.SPE_Major_project.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService
{
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Movie saveMovie(Movie movie) {
        if(movie==null)
        {
            return null;
        }
        Movie m=movieRepository.save(movie);

        return m;
    }

    @Override
    public List<Movie> searchMovie(String movieName) {
        if(movieName==null)return null;
        List<Movie> movies=movieRepository.findByMovieNameContaining(movieName);
        return movies;
    }

    @Override
    public boolean storeReview(String movieName,String review)
    {
        if(review==null)return false;
        Reviews r=Reviews.builder()
                .movieName(movieName)
                .review(review).build();
        reviewRepository.save(r);
        return true;
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.getDetailsOfAllMovies();
    }

    @Override
    public List<Reviews> getAllReviewsByMovieName(String movieName) {
        if(movieName==null)return null;

        return reviewRepository.getReviewByMovieName(movieName);


    }
}