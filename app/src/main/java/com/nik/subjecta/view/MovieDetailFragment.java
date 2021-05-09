package com.nik.subjecta.view;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.nik.subjecta.R;
import com.nik.subjecta.databinding.MovieDetailBinding;
import com.nik.subjecta.retrofit.MovieModel;

public class MovieDetailFragment extends BottomSheetDialogFragment {

    MovieDetailBinding mBinding;
    MovieModel.Result movieModel;

    public MovieDetailFragment(MovieModel.Result movieModel) {
        this.movieModel = movieModel;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        bottomSheetDialog.setOnShowListener(dialog -> {
            BottomSheetDialog dialogc = (BottomSheetDialog) dialog;
            FrameLayout bottomSheet = (FrameLayout) dialogc.findViewById(R.id.design_bottom_sheet);

            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
            bottomSheetBehavior.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });
        return bottomSheetDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.movie_detail, container, false);
        mBinding.setLifecycleOwner(this);
        mBinding.setModel(movieModel);

        return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
