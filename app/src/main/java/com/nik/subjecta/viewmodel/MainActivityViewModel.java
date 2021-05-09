package com.nik.subjecta.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.nik.subjecta.retrofit.MovieModel;
import com.nik.subjecta.retrofit.Repository;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<MovieModel> movieModelMutableLiveData;
    private MutableLiveData<MovieModel.Result> resultMutableLiveData;
    Repository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        init();
    }

    public void init() {

        movieModelMutableLiveData = new MutableLiveData<>();
        repository = new Repository(getApplication());
        resultMutableLiveData = new MutableLiveData<>();
    }

    public void getMovie(){
        repository.getMovies(movieModelMutableLiveData );
    }


    //getter and setter


    public MutableLiveData<MovieModel> getMovieModelMutableLiveData() {
        return movieModelMutableLiveData;
    }

    public void setMovieModelMutableLiveData(MutableLiveData<MovieModel> movieModelMutableLiveData) {
        this.movieModelMutableLiveData = movieModelMutableLiveData;
    }

    public MutableLiveData<MovieModel.Result> getResultMutableLiveData() {
        return resultMutableLiveData;
    }

    public void setResultMutableLiveData(MutableLiveData<MovieModel.Result> resultMutableLiveData) {
        this.resultMutableLiveData = resultMutableLiveData;
    }
}
