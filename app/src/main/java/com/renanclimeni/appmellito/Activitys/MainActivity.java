package com.renanclimeni.appmellito.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.renanclimeni.appmellito.Entidades.Usuarios;
import com.renanclimeni.appmellito.R;
import com.renanclimeni.appmellito.firebase.FirebaseConfig;

public class MainActivity extends Activity {
    private EditText edEmail, edSenha;
    private Button btEntrar, btCriar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = (EditText) findViewById(R.id.edtEmail);
        edSenha = (EditText) findViewById(R.id.edtSenha);
        btEntrar = (Button) findViewById(R.id.btnEntrar);
        btCriar = (Button) findViewById(R.id.btnCriar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edEmail.getText().toString().equals("")){
                    if (edSenha.getText().toString().equals("")){
                        alert("Preencha os campos de E-mail e Senha.");
                    }
                    else{
                        alert("Preencha o campo de E-mail.");
                    }
                }
                else if (edSenha.getText().toString().equals("")){
                    alert("Preencha o campo de senha");
                }
                else {
                    usuarios = new Usuarios();
                    usuarios.setEmail(edEmail.getText().toString());
                    usuarios.setSenha(edSenha.getText().toString());
                    valida();
                }
            }
        });

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Cadastro.class);
                startActivity(i);
            }
        });
    }

    public void alert (String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    private void valida(){
        autenticacao = FirebaseConfig.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(), usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent inMenu = new Intent(MainActivity.this, Menu.class);
                    startActivity(inMenu);
                }
                else{
                    alert("Senha incorreta!");
                }
            }
        });
    }
}
