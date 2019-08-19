package com.id.myloogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_logout;
    TextView txt_id, txt_username, txt_nama, txt_email, txt_no_hp ;
    String id, username, nama, email, no_hp;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_NO_HP = "no_hp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_username = (TextView) findViewById(R.id.txt_username);
        btn_logout = (Button) findViewById(R.id.btn_logout);
        txt_nama = (TextView) findViewById(R.id.txt_nama);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_no_hp = (TextView) findViewById(R.id.txt_no_hp);

        sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        nama = getIntent().getStringExtra(TAG_NAMA);
        email = getIntent().getStringExtra(TAG_EMAIL);
        no_hp = getIntent().getStringExtra(TAG_NO_HP);

        txt_username.setText("USERNAME : " + username);
        txt_nama.setText("NAMA: " + nama);
        txt_email.setText("EMAIL " + email);
        txt_no_hp.setText("NO HP : " + no_hp);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(Login.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_USERNAME, null);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, Login.class);
                finish();
                startActivity(intent);
            }
        });

    }
}
