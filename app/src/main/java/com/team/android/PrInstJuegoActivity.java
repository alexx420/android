package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by alexx420 on 21/03/2017.
 */

public class PrInstJuegoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr_inst_juego);
        findViewById(R.id.btn_siguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaSiguiente();
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
                startActivity(new Intent(PrInstJuegoActivity.this, PrInfo8Activity.class));
            }
        });
    }

    public void iniciaSiguiente() {
        Intent myIntent = new Intent(this, PrJuego3Activity.class);
        startActivity(myIntent);
    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
}
