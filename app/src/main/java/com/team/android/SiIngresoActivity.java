package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SiIngresoActivity extends AppCompatActivity {

    private int ingreso = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_ingreso);

        findViewById(R.id.radioButton_1).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_2).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_3).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_4).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_5).setOnClickListener(clickListener);

        findViewById(R.id.btn_siguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ingreso != -1)
                    iniciaSiguiente();
                else
                    Toast.makeText(SiIngresoActivity.this, "Selecciona un ingreso", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });
        findViewById(R.id.btn_anterior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SiIngresoActivity.this, SiInfo1Activity.class));
            }
        });
    }

    public void iniciaSiguiente() {
        Intent myIntent = new Intent(this, SiPlazoActivity.class);
        myIntent.putExtra("ingreso", ingreso);
        startActivity(myIntent);
    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.radioButton_5:
                    ingreso = 1;
                    break;
                case R.id.radioButton_4:
                    ingreso = 2;
                    break;
                case R.id.radioButton_3:
                    ingreso = 3;
                    break;
                case R.id.radioButton_2:
                    ingreso = 4;
                    break;
                case R.id.radioButton_1:
                    ingreso = 5;
                    break;
            }
            Toast.makeText(SiIngresoActivity.this, "Presiona siguiente para continuar", Toast.LENGTH_SHORT).show();
        }
    };


}