package com.example.thriv31.ui.updates;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.thriv31.Call_Schedule;
import com.example.thriv31.Chats;
import com.example.thriv31.Make_Request;
import com.example.thriv31.R;

import com.example.thriv31.databinding.FragmentUpdatesBinding;
import com.example.thriv31.made_Request;

public class UpdatesFragment extends Fragment {

    private FragmentUpdatesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UpdatesViewModel updatesViewModel =
                new ViewModelProvider(this).get(UpdatesViewModel.class);

        binding = FragmentUpdatesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View view = inflater.inflate(R.layout.fragment_updates, container, false);

        Button makeRequest = view.findViewById(R.id.makeRequest);
        makeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Make_Request.class);
                startActivity(intent);
            }
        });

        Button madeRequest = view.findViewById(R.id.madeRequest);
        madeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), made_Request.class);
                startActivity(intent);
            }
        });

        Button callSchedule = view.findViewById(R.id.callSchedule);
        madeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Call_Schedule.class);
                startActivity(intent);
            }
        });

        Button buttonchats = view.findViewById(R.id.Buttonchats);
        buttonchats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Chats.class);
                startActivity(intent);
            }
        });

        final TextView textView = binding.Updates;
        updatesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}