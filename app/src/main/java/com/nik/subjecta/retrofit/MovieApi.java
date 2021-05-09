package com.nik.subjecta.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("3/discover/movie?sort_by=popularity.desc&api_key=fd75d8c708d418f9ee6280f179e7f399")
    Call<MovieModel> getMovie();
}
