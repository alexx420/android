package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * Created by alexx420 on 21/03/2017.
 */

public class CrJuego1Activity extends AppCompatActivity {
    ImageButton dado;
    ImageButton home;
    private int meta = 22;
    private int pos = 0;
    private boolean ganador = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr_juego1);

        meta = 22;
        pos = 0;
        ganador = false;

        dado = (ImageButton) findViewById(R.id.btn_dado);
        home = (ImageButton) findViewById(R.id.btn_home);

        dado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tiraDado();
                } catch (Exception e) {
                    Log.e(this.toString(), e.getMessage());
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });

    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    public void mensajeGanador() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(CrJuego1Activity.this);
        alertDialog.setTitle("Felicidades");
        alertDialog.setMessage("¡Juego terminado!");
        alertDialog.show();
    }

    public void tiraDado() throws NoSuchFieldException, IllegalAccessException {
        //pregunta si es ganador
        if (ganador) {
            //si
            // muestra mensaje
            mensajeGanador();
        } else {
            //no
            // tira dado
            int valorDado = (int) Math.floor(Math.random() * 6 + 1);
            ImageView imgv_dado = (ImageView) findViewById(R.id.imageView_dado);
            switch (valorDado) {
                case 1:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado1);
                    break;
                case 2:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado2);
                    break;
                case 3:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado3);
                    break;
                case 4:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado4);
                    break;
                case 5:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado5);
                    break;
                case 6:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado6);
                    break;
            }
            int anterior = this.pos;
            //pregunta si llega a la meta
            if (this.pos + valorDado == this.meta) {
                //es ganador
                this.ganador = true;
                this.pos += valorDado;
            } else if (this.pos + valorDado > this.meta) {
                //pregunta si se pasa
                //no suma valor
            } else {
                this.pos += valorDado;
            }
            //pinta casillas
            //opaca casilla del tiro anterior
            int id_view = getId("imageViewC" + anterior, R.id.class);
            ImageView imgv_casilla = (ImageView) findViewById(id_view);
            int id_drwbl = getId("img_cr_casilla" + anterior + "_uf", R.drawable.class);
            imgv_casilla.setImageResource(id_drwbl);

            //activa casilla del tiro nuevo
            id_view = getId("imageViewC" + this.pos, R.id.class);
            imgv_casilla = (ImageView) findViewById(id_view);
            id_drwbl = getId("img_cr_casilla" + this.pos, R.drawable.class);
            imgv_casilla.setImageResource(id_drwbl);
            //pregunta si es ganador
            if (ganador) {
                //si
                // muestra mensaje
                mensajeGanador();
            }
        }
    }

    public static int getId(String resourceName, Class<?> c) throws IllegalAccessException, NoSuchFieldException {
        Field idField = c.getDeclaredField(resourceName);
        return idField.getInt(idField);
    }
}