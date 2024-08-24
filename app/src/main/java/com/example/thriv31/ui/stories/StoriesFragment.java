package com.example.thriv31.ui.stories;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.thriv31.R;
import com.example.thriv31.StoriesMessageAdapter;
import com.example.thriv31.databinding.FragmentStoriesBinding;
import com.example.thriv31.storiesMessage;

import java.util.ArrayList;
import java.util.List;


public class StoriesFragment extends Fragment {

    private RecyclerView recyclerViewMessages;
    private StoriesMessageAdapter messageAdapter;
    private List<storiesMessage> messageList;
    private EditText editTextMessage;
    private ImageButton buttonSend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories, container, false);

        recyclerViewMessages = view.findViewById(R.id.recyclerViewMessages);
        editTextMessage = view.findViewById(R.id.editTextMessage);
        buttonSend = view.findViewById(R.id.buttonSend);

        messageList = new ArrayList<>();
        messageAdapter = new StoriesMessageAdapter(messageList);

        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMessages.setAdapter(messageAdapter);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = editTextMessage.getText().toString().trim();
                if (!messageText.isEmpty()) {
                    // Replace "User Name" with the actual user name
                    messageList.add(new storiesMessage("User Name", messageText));
                    messageAdapter.notifyItemInserted(messageList.size() - 1);
                    recyclerViewMessages.scrollToPosition(messageList.size() - 1);
                    editTextMessage.setText("");
                }
            }
        });

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}


