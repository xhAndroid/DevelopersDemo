package com.app.architecture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import com.app.dd.databinding.FragmentDialogBindingViewBinding;

/**
 * -----------------------------------------------------------------
 * Copyright (C) by AppMan, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @author AppMan
 * @date Created on 2020/12/11
 */
public class BindingViewDialogFragment extends AppCompatDialogFragment {

    private FragmentDialogBindingViewBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDialogBindingViewBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        isShowFragment = false;
    }

    private boolean isShowFragment = false;

    public boolean isShowFragment() {
        return isShowFragment;
    }

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        if (this.isShowFragment) {
            return;
        }
        this.isShowFragment = true;
        super.show(manager, tag);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        this.isShowFragment = false;
    }
}
