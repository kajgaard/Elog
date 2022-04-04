package com.example.elog.ui.oversigt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.elog.databinding.FragmentOversigtBinding;

public class OversigtFragment extends Fragment {

    private FragmentOversigtBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        OversigtViewModel oversigtViewModel =
                new ViewModelProvider(this).get(OversigtViewModel.class);

        binding = FragmentOversigtBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textOversigt;
        oversigtViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}