package com.rosinante24.moviemvvm.Adapter;

import android.support.v7.app.AppCompatActivity;

import com.rosinante24.moviemvvm.Data.MovieAPIDao;
import com.rosinante24.moviemvvm.R;
import com.rosinante24.moviemvvm.ViewModel.MainRowVM;
import com.rosinante24.moviemvvm.databinding.ListRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by Rosinante24 on 9/27/17.
 */

public class MainAdapter extends GitsAdapter<MovieAPIDao, MainRowVM, ListRowBinding> {

    public MainAdapter(List<MovieAPIDao> listmovie) {
        super(listmovie);

    }

    @Override
    public MainRowVM createViewModel(AppCompatActivity activity, ListRowBinding binding, MovieAPIDao item, int position) {
        return new MainRowVM(activity, binding, item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_row;
    }

    @Override
    public void render(ListRowBinding binding, MainRowVM viewModel, MovieAPIDao item) {
        binding.setViewModels(viewModel);
    }

    @Override
    public void onRowClick(MovieAPIDao data, int position) {

    }
}
