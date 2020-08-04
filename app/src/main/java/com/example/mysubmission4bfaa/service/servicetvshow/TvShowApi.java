package com.example.mysubmission4bfaa.service.servicetvshow;

import com.example.mysubmission4bfaa.model.tvmodel.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TvShowApi {
    @GET("3/tv/popular?api_key=8a09bf10aa636b6ea95d9a108818dcd4")
    Call<TvShowResponse> getTvShows(@Query("language") String language);
}
