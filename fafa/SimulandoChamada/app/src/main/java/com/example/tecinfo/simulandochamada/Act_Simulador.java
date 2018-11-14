package com.example.tecinfo.simulandochamada;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Act_Simulador extends AppCompatActivity {


    String memoria = "";
    TextView txtnumero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__simulador);

        txtnumero = findViewById(R.id.txt_numero);
        final Button btn_1 = findViewById(R.id.btn_1);
        final Button btn_2 = findViewById(R.id.btn_2);
        final Button btn_3 = findViewById(R.id.btn_3);
        final Button btn_4 = findViewById(R.id.btn_4);
        final Button btn_5 = findViewById(R.id.btn_5);
        final Button btn_6 = findViewById(R.id.btn_6);
        final Button btn_7 = findViewById(R.id.btn_7);
        final Button btn_8 = findViewById(R.id.btn_8);
        final Button btn_9 = findViewById(R.id.btn_9);
        final Button btn_11 = findViewById(R.id.btn_11);
        final Button btn_0 = findViewById(R.id.btn_0);
        final Button btn_22 = findViewById(R.id.btn_22);
        final Button btn_lip = findViewById(R.id.btn_Lp);
        final ImageButton btn_ligar = findViewById(R.id.btn_ligar);

        btn_0.setOnClickListener(myListener);
        btn_1.setOnClickListener(myListener);
        btn_2.setOnClickListener(myListener);
        btn_3.setOnClickListener(myListener);
        btn_4.setOnClickListener(myListener);
        btn_5.setOnClickListener(myListener);
        btn_6.setOnClickListener(myListener);
        btn_7.setOnClickListener(myListener);
        btn_8.setOnClickListener(myListener);
        btn_9.setOnClickListener(myListener);
        btn_11.setOnClickListener(myListener);
        btn_22.setOnClickListener(myListener);
        btn_lip.setOnClickListener(myListener);
        btn_ligar.setOnClickListener(myListener);


    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_0:
                    setDisplaytext("0");
                    break;
                case R.id.btn_1:
                    setDisplaytext("1");
                    break;
                case R.id.btn_2:
                    setDisplaytext("2");
                    break;
                case R.id.btn_3:
                    setDisplaytext("3");
                    break;
                case R.id.btn_4:
                    setDisplaytext("4");
                    break;
                case R.id.btn_5:
                    setDisplaytext("5");
                    break;
                case R.id.btn_6:
                    setDisplaytext("6");
                    break;
                case R.id.btn_7:
                    setDisplaytext("7");
                    break;
                case R.id.btn_8:
                    setDisplaytext("8");
                    break;
                case R.id.btn_9:
                    setDisplaytext("9");
                    break;
                case R.id.btn_11:
                    setDisplaytext("*");
                    break;
                case R.id.btn_22:
                    setDisplaytext("#");
                    break;
                case R.id.btn_Lp:

                    if(memoria.length() > 0){
                        memoria = memoria.substring(0, memoria.length() - 1);
                        txtnumero.setText(memoria);
                    }
                    break;
                case R.id.btn_ligar:

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + memoria));
                    //intent.setData(Uri.parse("tel:0416316166"));

                    if(ActivityCompat.checkSelfPermission(Act_Simulador.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                        ActivityCompat.requestPermissions(Act_Simulador.this, new String[]{Manifest.permission.CALL_PHONE}, 0);

                    }
                    startActivity(intent);
                    break;
            }
        }
    };

    private void setDisplaytext(String memo) {
        memoria = memoria + memo;
        txtnumero.setText(memoria);
    }


}
