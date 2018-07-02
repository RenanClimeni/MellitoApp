package com.renanclimeni.appmellito.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.renanclimeni.appmellito.R;

public class Menu extends Activity {
    Button btProdutos;
    Button btCarrinho;
    Button btConfig;
    Button btHistoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btProdutos = (Button) findViewById(R.id.btnProdutos);
        btCarrinho = (Button) findViewById(R.id.btnCarrinho);
        btConfig = (Button) findViewById(R.id.btnConfig);
        btHistoria = (Button) findViewById(R.id.btnHistoria);

        btProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intProd = new Intent(Menu.this, MenuProdutos.class);
                startActivity(intProd);
            }
        });

        btCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intCar = new Intent(Menu.this, MenuCarrinho.class);
                startActivity(intCar);
            }
        });

        btConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intConfig = new Intent(Menu.this, MenuConfig.class);
                startActivity(intConfig);
            }
        });

        btHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intHist = new Intent(Menu.this, MenuHistoria.class);
                startActivity(intHist);
            }
        });
    }
}
