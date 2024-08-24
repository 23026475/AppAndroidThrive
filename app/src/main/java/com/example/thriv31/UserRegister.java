package com.example.thriv31;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserRegister extends AppCompatActivity {
    private EditText editTextFirstName, editTextLastName, editTextContact, editTextEmail, editTextPassword, editTextConfirmPassword;
    private Button buttonClearForm, buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextContact = findViewById(R.id.editTextContact);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonClearForm = findViewById(R.id.ClearForm);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Clear form button
        buttonClearForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });

        // Register button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void clearForm() {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        editTextContact.setText("");
        editTextEmail.setText("");
        editTextPassword.setText("");
        editTextConfirmPassword.setText("");
    }

    private void registerUser() {
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String contact = editTextContact.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if (password.equals(confirmPassword)) {
            // Call method to save data to the database
            saveUserDataToDatabase(firstName, lastName, contact, email, password);
        } else {
            Toast.makeText(UserRegister.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveUserDataToDatabase(String firstName, String lastName, String contact, String email, String password) {
        // Send data to PHP script hosted on XAMPP
        // Use Volley or Retrofit for network requests

        // Example with Volley
        // String url = "http://your-server-ip/register_user.php";
        // Code to make POST request goes here

        // After successful registration, go to login page
        Intent intent = new Intent(UserRegister.this, Login.class);
        startActivity(intent);
        finish();
    }
}