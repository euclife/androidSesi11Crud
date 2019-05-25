package com.chandra.crudsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chandra.crudsql.helper.DatabaseHelper;

public class LoginActivirty extends AppCompatActivity {

    EditText edNama;
    EditText edPassword;
    Button btnLogin;
    Button btnRegister;
    RadioGroup rgRole;

    //Masukkan Helper nya
    DatabaseHelper dbHelper = null;

    //Masukkan SQLitenya
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edNama = findViewById(R.id.edNama);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        rgRole = findViewById(R.id.rgRole);

        dbHelper = new DatabaseHelper(LoginActivirty.this);
        db = dbHelper.getWritableDatabase();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login("chandra", "123456")){
                    Intent intent = new Intent(LoginActivirty.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivirty.this, "Login Gagal Gan ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivirty.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean login(final String nama, final String password){
        String query = String.format("SELECT * FROM user WHERE nama = '%s' AND password = '%s' ", nama, password);
        Cursor cursor = db.rawQuery(query, null);

        //Pindahkan cursor ke record awal
        return cursor != null && cursor.moveToFirst() && cursor.getCount() > 0;
    }
}
