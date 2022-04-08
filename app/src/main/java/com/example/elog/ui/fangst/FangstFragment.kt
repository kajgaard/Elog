package com.example.elog.ui.fangst;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.elog.databinding.FragmentFangstBinding;

public class FangstFragment extends Fragment {

    private FragmentFangstBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FangstViewModel fangstViewModel =
                new ViewModelProvider(this).get(FangstViewModel.class);

        binding = FragmentFangstBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFangst;
        fangstViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}