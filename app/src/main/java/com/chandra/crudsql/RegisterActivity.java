package com.chandra.crudsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chandra.crudsql.classes.UserEntity;
import com.chandra.crudsql.helper.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {


    EditText edNama;
    EditText edPassword;
    Button btnRegister;
    RadioGroup rgRole;
    RadioButton rbAdmin;

    //Masukkan Helper nya
    DatabaseHelper dbHelper = null;

    //Masukkan SQLitenya
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = rgRole.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1){
                    UserEntity entity = new UserEntity("chandra","123456");
                    long register = RegisterActivity.this.register(entity);

                    if (register < 0){
                        Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    //Registrasi Data Baru pada database
    private long register (UserEntity entity){
        ContentValues values= new ContentValues();
        values.put(UserEntity.COLOUMN_NAMA, entity.getNama());
        values.put(UserEntity.COLOUMN_PASSWORD, entity.getPassword());
        values.put(UserEntity.COLOUMN_IS_LOGIN, 0);
        values.put(UserEntity.COLOUMN_ROLE, rbAdmin.isChecked() ? 1 : 0 );

        //Insert ke table user
        return db.insert(UserEntity.TABLE_NAME, null, values);
    }


}
