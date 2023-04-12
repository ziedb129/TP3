package com.example.operateurs_tlephoniques;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button _ConnexionBtn;
    EditText _Edt_login;
    EditText _Edt_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _Edt_login=(EditText) findViewById(R.id.Edt_login);
        _Edt_pwd=(EditText) findViewById(R.id.Edt_pwd);
        _ConnexionBtn=(Button) findViewById(R.id.ConnexionBtn);
        _ConnexionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd= _Edt_pwd.getText().toString();
                String login= _Edt_login.getText().toString();
                if(pwd.equals("slim")){
                Intent intent= new Intent(MainActivity.this,ApplicationPage.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("key", login);
                    intent.putExtras(bundle);
                startActivity(intent);

                }
                else{
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Error")
                            .setMessage("Le mot de pass est incorrect")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    // do something
                                }
                            })
                            .show();

                }
            }
        });
    }
}