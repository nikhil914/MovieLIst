package com.nik.subjecta.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.nik.subjecta.R;
import com.nik.subjecta.databinding.ActivityMainBinding;
import com.nik.subjecta.retrofit.MovieModel;
import com.nik.subjecta.util.BaseClass;
import com.nik.subjecta.util.MovieAdapter;
import com.nik.subjecta.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    MainActivityViewModel mviewModel;
    RecyclerView recyclerView;

    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setLifecycleOwner(this);

        mviewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MainActivityViewModel.class);
        recyclerView = mBinding.recyclerview;


        observeLiveData();

        mviewModel.getMovie();
    }



    private void observeLiveData() {
        mviewModel.getMovieModelMutableLiveData().observe(this, new Observer<MovieModel>() {
            @Override
            public void onChanged(MovieModel movieModel) {
                Log.i("TAG", "onChanged: ");
                if (movieModel != null) {
                    movieAdapter = new MovieAdapter(getApplicationContext(), movieModel.getResults(), mviewModel.getResultMutableLiveData());
                    recyclerView.setAdapter(movieAdapter);

                }
            }
        });

        mviewModel.getResultMutableLiveData().observe(this, new Observer<MovieModel.Result>() {
            @Override
            public void onChanged(MovieModel.Result result) {

                if (result != null)
                    viewDetail(result);
            }
        });
    }

    public void viewDetail(MovieModel.Result m) {
        MovieDetailFragment detailFragment = new MovieDetailFragment(m);
        detailFragment.show(getSupportFragmentManager(), "tag");

    }
}