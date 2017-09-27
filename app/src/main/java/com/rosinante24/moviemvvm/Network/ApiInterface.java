package com.rosinante24.moviemvvm.Network;

import com.rosinante24.moviemvvm.Data.MovieListDao;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Rosinante24 on 9/27/17.
 */

public interface ApiInterface {
    @GET("popular")
    Observable<MovieListDao> getMovie(
            @Query("api_key") String api_key
    );
}
