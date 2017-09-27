package com.rosinante24.moviemvvm.ViewModel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rosinante24.moviemvvm.Data.BaseAPIDao;
import com.rosinante24.moviemvvm.Data.MovieAPIDao;
import com.rosinante24.moviemvvm.R;
import com.rosinante24.moviemvvm.databinding.ListRowBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by Rosinante24 on 9/27/17.
 */

public class MainRowVM extends GitsRowVM<MovieAPIDao, ListRowBinding> {
    public ObservableField<String> urlImage = new ObservableField<>();
    public ObservableField<String> textJudul = new ObservableField<>();
    public ObservableField<String> textvote = new ObservableField<>();
    public ObservableField<String> textpopularity = new ObservableField<>();
    public ObservableField<String> textrelease = new ObservableField<>();

    public MainRowVM(AppCompatActivity activity, ListRowBinding binding, MovieAPIDao item) {
        super(activity, binding, item);
         BaseAPIDao baseAPIDao = new BaseAPIDao();

        textJudul.set(item.getTitle());
        urlImage.set("http://image.tmdb.org/t/p/w185" + item.getPoster_path());
        textvote.set("Voted by : " + item.getVote_count() + " peoples");
        textpopularity.set("Popularity : " + item.getPopularity());
        textrelease.set("Released at : " + baseAPIDao.getRelease_date());

    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .crossFade()
                .placeholder(R.mipmap.ic_launcher_round)
                .into(imageView);
    }

}
