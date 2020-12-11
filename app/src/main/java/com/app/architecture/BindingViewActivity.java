package com.app.architecture;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.app.dd.databinding.ActivityBindingViewBinding;

/**
 * -----------------------------------------------------------------
 * Copyright (C) by AppMan, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @author AppMan
 * @date Created on 2020/12/11
 */
public class BindingViewActivity extends AppCompatActivity {

    private ActivityBindingViewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBindingViewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.tvName.setText("bing test -> used");
        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogFragment();
            }
        });
    }

    private BindingViewDialogFragment dialogFragment;

    private void showDialogFragment() {
        if (null == dialogFragment) {
            dialogFragment = new BindingViewDialogFragment();
        } else if (dialogFragment.isShowFragment()) {
            return;
        }
        dialogFragment.show(getSupportFragmentManager(), BindingViewDialogFragment.class.getSimpleName());
    }

}
