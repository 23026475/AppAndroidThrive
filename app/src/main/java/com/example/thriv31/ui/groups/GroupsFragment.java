package com.example.thriv31.ui.groups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thriv31.EventAdapter;
import com.example.thriv31.Events;
import com.example.thriv31.R;
import com.example.thriv31.databinding.FragmentGroupsBinding;

import java.util.ArrayList;
import java.util.List;

public class GroupsFragment extends Fragment {

    private FragmentGroupsBinding binding;

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<Events> eventList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_groups, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.groupEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize event list and adapter
        eventList = new ArrayList<>();
        eventList.add(new Events("Social Empowerment Meetup", "2024-09-15", "10:00 AM", "Community Center"));
        eventList.add(new Events("Women in Tech Conference", "2024-09-20", "2:00 PM", "Tech Park"));
        // Add more events here

        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}