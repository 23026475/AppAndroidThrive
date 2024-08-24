package com.example.thriv31.ui.account;

import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.thriv31.R;
import com.example.thriv31.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {

    private Switch switchDarkMode;
    private TextView textViewUserName;
    private ImageView imageViewProfilePicture;
    private Button buttonChangeProfilePicture, buttonChangePassword;
    private static final int PICK_IMAGE = 100;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        // Initialize UI components
        switchDarkMode = view.findViewById(R.id.switchDarkMode);
        textViewUserName = view.findViewById(R.id.textViewUserName);
        imageViewProfilePicture = view.findViewById(R.id.imageViewProfilePicture);
        buttonChangeProfilePicture = view.findViewById(R.id.buttonChangeProfilePicture);
        buttonChangePassword = view.findViewById(R.id.buttonChangePassword);

        // Set up dark mode switch
        setupDarkModeSwitch();

        // Display the username
        displayUsername();

        // Handle change profile picture action
        buttonChangeProfilePicture.setOnClickListener(v -> openGallery());

        // Handle change password action
        buttonChangePassword.setOnClickListener(v -> showChangePasswordDialog());

        return view;
    }

    private void setupDarkModeSwitch() {
        // Check current theme
        boolean isDarkMode = (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
        switchDarkMode.setChecked(isDarkMode);

        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }

    private void displayUsername() {
        // Assuming you have a method to get the username from the database or shared preferences
        String username = getUsernameFromDatabase(); // Replace with actual implementation
        textViewUserName.setText(username);
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri imageUri = data.getData();
            imageViewProfilePicture.setImageURI(imageUri);

            // Implement uploading the image to the server
            uploadProfilePictureToServer(imageUri);
        }
    }

    private void showChangePasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Change Password");

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_change_password, (ViewGroup) getView(), false);
        final EditText inputOldPassword = viewInflated.findViewById(R.id.inputOldPassword);
        final EditText inputNewPassword = viewInflated.findViewById(R.id.inputNewPassword);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.ok, (dialog, which) -> {
            dialog.dismiss();
            String oldPassword = inputOldPassword.getText().toString();
            String newPassword = inputNewPassword.getText().toString();
            changePasswordOnServer(oldPassword, newPassword); // Implement this method to handle the password change on the server
        });
        builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void changePasswordOnServer(String oldPassword, String newPassword) {
        // Implement network request to change password on XAMPP server
        // Example: Use Retrofit or OkHttp to send request
    }

    private void uploadProfilePictureToServer(Uri imageUri) {
        // Implement network request to upload profile picture to server
        // Example: Use Retrofit or OkHttp to send request
    }

    private String getUsernameFromDatabase() {
        // Implement method to retrieve username from database or shared preferences
        return "Sample Username"; // Replace with actual implementation
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}
