package com.example.thriv31;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserRegister extends AppCompatActivity {

    private EditText firstName, lastName, contactNumber, email, password, confirmPassword;
    private Button registerButton, clearFormButton, loginButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        databaseHelper = new DatabaseHelper(this);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        contactNumber = findViewById(R.id.contactNumber);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        registerButton = findViewById(R.id.registerButton);
        clearFormButton = findViewById(R.id.clearFormButton);
        loginButton = findViewById(R.id.loginButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNameInput = firstName.getText().toString();
                String lastNameInput = lastName.getText().toString();
                String contactNumberInput = contactNumber.getText().toString();
                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();
                String confirmPasswordInput = confirmPassword.getText().toString();

                if (TextUtils.isEmpty(firstNameInput) || TextUtils.isEmpty(lastNameInput) ||
                        TextUtils.isEmpty(contactNumberInput) || TextUtils.isEmpty(emailInput) ||
                        TextUtils.isEmpty(passwordInput) || TextUtils.isEmpty(confirmPasswordInput)) {
                    Toast.makeText(UserRegister.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (!passwordInput.equals(confirmPasswordInput)) {
                    Toast.makeText(UserRegister.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = databaseHelper.insertUserData(firstNameInput, lastNameInput, contactNumberInput, emailInput, passwordInput);
                    if (isInserted) {
                        Toast.makeText(UserRegister.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserRegister.this, Login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(UserRegister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        clearFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText("");
                lastName.setText("");
                contactNumber.setText("");
                email.setText("");
                password.setText("");
                confirmPassword.setText("");
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserRegister.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
