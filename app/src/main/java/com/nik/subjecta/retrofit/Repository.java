package com.nik.subjecta.retrofit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.nik.subjecta.util.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    Context context;
    MovieApi movieApi;

    public Repository(Context context) {
        this.context = context;
        movieApi = RetrofitService.createService(MovieApi.class);
    }

    public void getMovies(MutableLiveData<MovieModel> movieModelMutableLiveData) {
        movieApi.getMovie().enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                Log.i("TAG", "onResponse: ");

                if (response.isSuccessful()) {
                    movieModelMutableLiveData.postValue(response.body());
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
