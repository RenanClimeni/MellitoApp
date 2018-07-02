package com.renanclimeni.appmellito.Activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.renanclimeni.appmellito.R;

public class MenuCarrinho extends Activity {
    private TextView txPote300, txPote250, txSache, txTotalFinal;
    private MenuProdutos t = new MenuProdutos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_carrinho);

        txPote300 = (TextView) findViewById(R.id.txtPote300);
        txPote250 = (TextView) findViewById(R.id.txtPote250);
        txSache = (TextView) findViewById(R.id.txtSache);
        txTotalFinal = (TextView) findViewById(R.id.txtTotalFinal);
    }
}
