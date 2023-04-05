package ferrando.alejandro.justveganproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText emailLogin, passLogin;
    Button login, forgot;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.emailLogIn);
        passLogin = findViewById(R.id.passwordLogIn);
        login = findViewById(R.id.buttonLogIn);
        forgot = findViewById(R.id.forgot);
        db = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = emailLogin.getText().toString();
                String passwordText = passLogin.getText().toString();
                if (db.existeUser(emailText, passwordText)) {
                    Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "User don't exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "This don't work lol", Toast.LENGTH_SHORT).show();
            }
        });
    }
}