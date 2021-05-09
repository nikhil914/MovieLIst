package com.nik.subjecta.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.nik.subjecta.R;
import com.nik.subjecta.databinding.MovieItemBinding;
import com.nik.subjecta.retrofit.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<MovieModel.Result> mList;
    MutableLiveData<MovieModel.Result> resultMutableLiveData;

    public MovieAdapter(Context context, List<MovieModel.Result> mList, MutableLiveData<MovieModel.Result> resultMutableLiveData) {
        this.context = context;
        this.mList = mList;
        this.resultMutableLiveData = resultMutableLiveData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemBinding.setModel(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MovieItemBinding itemBinding;

        public ViewHolder(@NonNull MovieItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
            itemBinding.setClickHandler(new ClickHandler());

        }
    }

    public class ClickHandler {
        public void viewMovie(MovieModel.Result model) {
            resultMutableLiveData.setValue(model);
        }
    }
}
