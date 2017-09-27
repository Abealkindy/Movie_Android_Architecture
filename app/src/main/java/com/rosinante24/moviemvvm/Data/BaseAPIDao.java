package com.rosinante24.moviemvvm.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rosinante24 on 9/27/17.
 */

public class BaseAPIDao {

   @SerializedName("results")
    private List<MovieAPIDao> movieAPIDaos;
    @SerializedName("release_date")
    private String release_date;

    public String getRelease_date() {
        return release_date;
    }

    public List<MovieAPIDao> getMovieAPIDaos() {
        return movieAPIDaos;
    }
}
