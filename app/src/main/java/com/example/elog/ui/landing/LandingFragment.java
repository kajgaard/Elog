package com.example.elog.ui.landing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.elog.databinding.FragmentLandingBinding;
import com.example.elog.ui.melding.MeldingViewModel;

public class LandingFragment extends Fragment {

    private FragmentLandingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LandingViewModel landingViewModel =
                new ViewModelProvider(this).get(LandingViewModel.class);

        binding = FragmentLandingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLanding;
        landingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}