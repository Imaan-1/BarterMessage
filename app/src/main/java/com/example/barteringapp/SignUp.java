package com.example.barteringapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    EditText editFirstName, editLastname, editEmail, editPassword, editFacName;

Button buttonSignUp, buttonGoSignIn;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editFirstName = findViewById(R.id.editTextFirstName);
        editLastname =findViewById(R.id.editTextLastName);
        editEmail = findViewById(R.id.editTextEmail);
        editFacName =findViewById(R.id.editTextFacilityName);
        editPassword = findViewById(R.id.editTextPassword);








        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode= FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                reference.setValue("First Data Storage");
                String Firstname = ((EditText)findViewById(R.id.editTextFirstName)).getText().toString();
                String Lastname = ((EditText)findViewById(R.id.editTextLastName)).getText().toString();
                String Farmingname = ((EditText)findViewById(R.id.editTextFacilityName)).getText().toString();
                String Email = ((EditText)findViewById(R.id.editTextEmail)).getText().toString();
                String Password = ((EditText)findViewById(R.id.editTextPassword)).getText().toString();

                // USER HELPER INSTANCE
                UserHelper helper = new UserHelper(Firstname, Lastname, Email, Password, Farmingname);
                reference.child(Farmingname).setValue(helper);
                Intent intent = new Intent(SignUp.this, Home.class);
                startActivity(intent);


                Toast.makeText(SignUp.this, "Sign Up complete!", Toast.LENGTH_LONG).show();

            }










        });

        buttonGoSignIn = findViewById(R.id.buttonGoSignIn);
        buttonGoSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUp.this, SignIn.class);
            startActivity(intent);
        });
    }
}