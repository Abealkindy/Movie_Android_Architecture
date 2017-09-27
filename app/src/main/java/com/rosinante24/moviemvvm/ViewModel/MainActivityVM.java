package com.rosinante24.moviemvvm.ViewModel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.rosinante24.moviemvvm.Adapter.MainAdapter;
import com.rosinante24.moviemvvm.Data.MovieAPIDao;
import com.rosinante24.moviemvvm.Data.MovieListDao;
import com.rosinante24.moviemvvm.Network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rosinante24 on 9/27/17.
 */

public class MainActivityVM extends GitsVM {
    private final List<MovieAPIDao> listmovie = new ArrayList<>();
    public GridLayoutManager layoutmanager;
    public MainAdapter recycleradapter;
    public static final String API_KEY = "1b0b39b7699af0ca010cd87d9e6de6c8";

    public MainActivityVM(Context context) {
        super(context);
        recycleradapter = new MainAdapter(listmovie);
        layoutmanager = new GridLayoutManager(mContext, 2);
        callApi();
    }

    private void callApi() {
        addSubscription(
                ApiClient
                .getInstance()
                .getEndPoint()
                .getMovie(API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<MovieListDao>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(MovieListDao movieListDao) {

                        listmovie.addAll(movieListDao.getMovieAPIDaos());
                        recycleradapter.notifyDataSetChanged();
                    }
                })
        );
    }
}
