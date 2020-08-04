package com.example.mysubmission4bfaa.service.servicemovie;

import com.example.mysubmission4bfaa.model.moviemodel.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("3/movie/popular?api_key=8a09bf10aa636b6ea95d9a108818dcd4")
    Call<MovieResponse> getMovies(@Query("language") String language);
}
