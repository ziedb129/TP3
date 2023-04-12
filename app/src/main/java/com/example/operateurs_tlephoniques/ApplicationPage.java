package com.example.operateurs_tlephoniques;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;


public class ApplicationPage extends Activity {
     TextView _login;
     EditText _Edt_telnum;
     TextView _res;
     EditText _Edt_code;
     EditText _Edt_GeneratedCode;
     Button _btn_Appeler;
     Button _btn_Appeler2;
     EditText _Edt_GeneratedCode2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_page);
        _Edt_telnum=(EditText) findViewById(R.id.Edt_telnum);
        _Edt_code=(EditText) findViewById(R.id.Edt_code);
        _Edt_GeneratedCode=(EditText) findViewById(R.id.Edt_GeneratedCode);
        _Edt_GeneratedCode2=(EditText) findViewById(R.id.Edt_GeneratedCode2);
        _login=(TextView) findViewById(R.id.login);
        _res=(TextView) findViewById(R.id.res);
        _btn_Appeler=(Button) findViewById(R.id.btn_Appeler);
        _btn_Appeler2=(Button) findViewById(R.id.btn_Appeler2);
        Bundle bundle = getIntent().getExtras();
        String value = bundle.getString("key");
        _login.setText(value);

        _Edt_telnum.addTextChangedListener(new TextWatcher() {
            String numtel= _Edt_telnum.getText().toString();

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // Get the first character of the string
                if (s.length() > 0 && start == 0) {
                    char firstChar = s.charAt(0);

                if (firstChar == '3'|| firstChar == '5') {

                   _res.setText("votre ligne est Orange");

                    _res.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));

                    Handler handler = new Handler(Looper.getMainLooper());
                    final Runnable[] runnable = {null};

                    _Edt_code.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            String numtel=_Edt_telnum.getText().toString();
                            if (!(numtel.length() == 8 && numtel.matches("[0-9]+"))) {
                                new AlertDialog.Builder(ApplicationPage.this)
                                        .setTitle("Error")
                                        .setMessage("Le numero de téléphone doit étre de 8 chiffre")
                                        .setPositiveButton("OK",null
                                        )
                                        .show();
                            }
                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            // Called during the text change.
                            handler.removeCallbacks(runnable[0]);
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            // Called after the text has been changed.
                            String code= _Edt_code.getText().toString();
                            runnable[0] = new Runnable() {
                                @Override
                                public void run() {
                                    _Edt_GeneratedCode.setText("*100*"+code+"#");
                                    _Edt_GeneratedCode.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                                    _Edt_GeneratedCode2.setText("*111#");
                                    _Edt_GeneratedCode2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));

                                }
                            };
                            handler.postDelayed(runnable[0], 1000); // Delay for 1 second (1000ms) before triggering the event.
                        }
                    });



                } else if (firstChar == '2') {
                    _res.setText("votre ligne est Ooredoo");

                    _res.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                    Handler handler = new Handler(Looper.getMainLooper());
                    final Runnable[] runnable = {null};

                    _Edt_code.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            String numtel=_Edt_telnum.getText().toString();
                            if (!(numtel.length() == 8 && numtel.matches("[0-9]+"))) {
                                new AlertDialog.Builder(ApplicationPage.this)
                                        .setTitle("Error")
                                        .setMessage("Le numero de téléphone doit étre de 8 chiffre")
                                        .setPositiveButton("OK",null
                                        )
                                        .show();
                            }
                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            // Called during the text change.
                            handler.removeCallbacks(runnable[0]);
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            // Called after the text has been changed.
                            String code= _Edt_code.getText().toString();
                            runnable[0] = new Runnable() {
                                @Override
                                public void run() {
                                    _Edt_GeneratedCode.setText("*101*"+code+"#");
                                    _Edt_GeneratedCode.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                                    _Edt_GeneratedCode2.setText("*100#");
                                    _Edt_GeneratedCode2.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));

                                }
                            };
                            handler.postDelayed(runnable[0], 1000); // Delay for 1 second (1000ms) before triggering the event.
                        }
                    });

                } else if (firstChar == '9') {
                    _res.setText("votre ligne est Tunisie Telecome");

                    _res.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
                    Handler handler = new Handler(Looper.getMainLooper());
                    final Runnable[] runnable = {null};

                    _Edt_code.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            String numtel=_Edt_telnum.getText().toString();
                            if (!(numtel.length() == 8 && numtel.matches("[0-9]+"))) {
                                new AlertDialog.Builder(ApplicationPage.this)
                                        .setTitle("Error")
                                        .setMessage("Le numero de téléphone doit étre de 8 chiffre")
                                        .setPositiveButton("OK",null
                                        )
                                        .show();
                            }
                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            // Called during the text change.
                            handler.removeCallbacks(runnable[0]);
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            // Called after the text has been changed.
                            String code= _Edt_code.getText().toString();
                            runnable[0] = new Runnable() {
                                @Override
                                public void run() {
                                    _Edt_GeneratedCode.setText("*123*"+code+"#");
                                    _Edt_GeneratedCode.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
                                    _Edt_GeneratedCode2.setText("*122#");
                                    _Edt_GeneratedCode2.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));

                                }
                            };
                            handler.postDelayed(runnable[0], 1000); // Delay for 1 second (1000ms) before triggering the event.
                        }
                    });

                }else {
                    _res.setText("Votre ligne est ...");
                    _res.setTextColor(getResources().getColor(android.R.color.black));
                }
            }}

            @Override
            public void afterTextChanged(Editable s) {


            }
        });



        _btn_Appeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recharge=_Edt_GeneratedCode.getText().toString();
                String code=_Edt_code.getText().toString();
                if (!(code.length() == 14 && code.matches("[0-9]+"))) {
                    new AlertDialog.Builder(ApplicationPage.this)
                            .setTitle("Error")
                            .setMessage("Le code de recharge doit étre de 14 chiffre")
                            .setPositiveButton("OK",null
                            )
                            .show();
                }else{
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + Uri.encode(recharge)));
                startActivity(intent);}

            }
        });
        _btn_Appeler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Solde=_Edt_GeneratedCode2.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + Uri.encode(Solde)));
                startActivity(intent);

            }
        });

    }
}