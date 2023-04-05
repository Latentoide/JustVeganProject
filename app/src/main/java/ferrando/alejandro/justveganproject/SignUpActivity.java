package ferrando.alejandro.justveganproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ferrando.alejandro.justveganproject.model.User;

public class SignUpActivity extends AppCompatActivity {

    EditText email;
    EditText password, confirmPass;
    Button butConfirm;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = findViewById(R.id.SignUpEmail);
        password = findViewById(R.id.SignUpPass);
        confirmPass = findViewById(R.id.SignUpPassConf);
        db = new DBHelper(this);
        butConfirm = findViewById(R.id.buttonSignUp);

        butConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                String confirmPassText = confirmPass.getText().toString();

                if (passwordText.equals(confirmPassText)) {
                    if(db.insertarUser(new User(emailText, passwordText,0,0))){
                        Toast.makeText(SignUpActivity.this, "User created!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignUpActivity.this, "Duplicated email", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignUpActivity.this, "You need to make right you'r password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}