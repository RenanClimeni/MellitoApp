package com.renanclimeni.appmellito.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.renanclimeni.appmellito.R;

public class MenuProdutos extends Activity {
   private TextView txQtd300g,txQtd250g, txQtdSache,txTotal, txTotal2, txTotal3;
   private Button btAdd300g, btSubt300g;
   private Button btAdd250g, btSubt250g;
   private Button btAddSache, btSubtSache;
   private Button btCarrinho;
   private Double total, total2, total3;
   private Integer qtd1, qtd2, qtd3;
   private String totalFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_produtos);

        txQtd300g = (TextView) findViewById(R.id.txtQtd300g);
        btAdd300g = (Button) findViewById(R.id.btnAdd);
        btSubt300g = (Button) findViewById(R.id.btnSubt);
        txTotal = (TextView) findViewById(R.id.txtTotal);
        txTotal2 = (TextView) findViewById(R.id.txtTotal2);
        txTotal3 = (TextView) findViewById(R.id.txtTotal3);
        btAdd250g= (Button) findViewById(R.id.btnAdd2);
        btSubt250g = (Button) findViewById(R.id.btnSubt2);
        btAddSache = (Button) findViewById(R.id.btnAdd3);
        btSubtSache = (Button) findViewById(R.id.btnSubt3);
        txQtd250g = (TextView) findViewById(R.id.txtQtd250g);
        txQtdSache = (TextView) findViewById(R.id.txtQtdSache);
        btCarrinho = (Button) findViewById(R.id.btnCarrinho);

        btAdd300g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtd1 = Integer.parseInt(txQtd300g.getText().toString());
                qtd1++;
                txQtd300g.setText(qtd1.toString());
                total = qtd1 * 16.00;
                txTotal.setText(total.toString());
            }
        });

        btSubt300g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtd1 = Integer.parseInt(txQtd300g.getText().toString());
                if (qtd1 != 0)
                {
                    qtd1--;
                    txQtd300g.setText(qtd1.toString());
                }
                total = qtd1 * 16.00;
                txTotal.setText(total.toString());
            }
        });

        btAdd250g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtd2 = Integer.parseInt(txQtd250g.getText().toString());
                qtd2++;
                txQtd250g.setText(qtd2.toString());
                total2 = qtd2 * 16.00;
                txTotal2.setText(total2.toString());
            }
        });

        btSubt250g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtd2 = Integer.parseInt(txQtd250g.getText().toString());
                if (qtd2 != 0)
                {
                    qtd2--;
                    txQtd250g.setText(qtd2.toString());
                }
                total2 = qtd2 * 16.00;
                txTotal2.setText(total2.toString());
            }
        });

        btAddSache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtd3 = Integer.parseInt(txQtdSache.getText().toString());
                qtd3++;
                txQtdSache.setText(qtd3.toString());
                total3 = qtd3 * 3.00;
                txTotal3.setText(total3.toString());
            }
        });

        btSubtSache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtd3 = Integer.parseInt(txQtdSache.getText().toString());
                if (qtd3 != 0)
                {
                    qtd3--;
                    txQtdSache.setText(qtd3.toString());
                }
                total3 = qtd3 * 3.00;
                txTotal3.setText(total3.toString());
            }
        });

        btCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuProdutos.this, MenuCarrinho.class);
                startActivity(intent);
            }
        });
    }
}
