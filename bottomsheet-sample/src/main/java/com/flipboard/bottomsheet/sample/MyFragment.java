package com.flipboard.bottomsheet.sample;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.R;
import com.flipboard.bottomsheet.ViewTransformer;
import com.flipboard.bottomsheet.commons.BottomSheetFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyFragment extends BottomSheetFragment {

    private MyAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rcl);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(new String[]{"Test"});
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("MyFragment", "setmDataset");

                mAdapter.setmDataset(new String[]{
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test"
                });
            }
        }, 100);
    }

    @Override
    public ViewTransformer getViewTransformer() {
        return new ViewTransformer() {
            @Override
            public void transformView(float translation, float maxTranslation, float peekedTranslation, BottomSheetLayout parent, View view) {

            }

            @Override
            public float getDimAlpha(float translation, float maxTranslation, float peekedTranslation, BottomSheetLayout parent, View view) {
                return 0;
            }
        };
    }
}
