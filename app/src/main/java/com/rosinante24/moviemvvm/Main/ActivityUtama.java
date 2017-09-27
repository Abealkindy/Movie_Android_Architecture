package com.rosinante24.moviemvvm.Main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rosinante24.moviemvvm.R;
import com.rosinante24.moviemvvm.ViewModel.MainActivityVM;
import com.rosinante24.moviemvvm.databinding.ActivityUtamaBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class ActivityUtama extends GitsActivity<MainActivityVM, ActivityUtamaBinding> {


    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_utama;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

    @Override
    public void bindViewModel(ActivityUtamaBinding binding, MainActivityVM viewModel) {
        binding.setViewModels(viewModel);
    }
}
