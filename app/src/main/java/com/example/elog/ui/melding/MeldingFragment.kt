package com.example.elog.ui.melding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.elog.databinding.FragmentMeldingBinding;

public class MeldingFragment extends Fragment {

    private FragmentMeldingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MeldingViewModel meldingViewModel =
                new ViewModelProvider(this).get(MeldingViewModel.class);

        binding = FragmentMeldingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMelding;
        meldingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}