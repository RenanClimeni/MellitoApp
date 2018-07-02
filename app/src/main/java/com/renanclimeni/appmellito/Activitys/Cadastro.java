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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.renanclimeni.appmellito.Entidades.Usuarios;
import com.renanclimeni.appmellito.Helper.Base64Custom;
import com.renanclimeni.appmellito.Helper.Preferencias;
import com.renanclimeni.appmellito.R;
import com.renanclimeni.appmellito.firebase.FirebaseConfig;

public class Cadastro extends Activity {
    private EditText edCadnome, edCademail, edCadsenha, edConfsenha;
    private Button btCadastrar;
    private Usuarios usuarios;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edCadnome = findViewById(R.id.edtNome);
        edCademail = findViewById(R.id.edtCademail);
        edCadsenha = findViewById(R.id.edtCadsenha);
        edConfsenha = findViewById(R.id.edtConfsenha);
        btCadastrar = findViewById(R.id.btnCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edCadnome.getText().toString().equals("")){
                    alert("Preencha todos os campos");
                }
                if (edCademail.getText().toString().equals("")){
                    alert("Preencha todos os campos");
                }
                if (edCadsenha.getText().toString().equals("")){
                    alert("Preencha todos os campos");
                }
                if (edConfsenha.getText().toString().equals("")){
                    alert("Preencha todos os campos");
                }
                if (edCadsenha.getText().toString().equals(edConfsenha.getText().toString())){
                    usuarios = new Usuarios();
                    usuarios.setNome(edCadnome.getText().toString());
                    usuarios.setEmail(edCademail.getText().toString());
                    usuarios.setSenha(edCadsenha.getText().toString());

                    cadUsuario();
                }
                else{
                    alert("As senhas não correspondem.");
                }
            }
        });
    }
    public void alert (String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    private void cadUsuario()
    {
        autenticacao = FirebaseConfig.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(usuarios.getEmail(), usuarios.getSenha()).addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    alert("Cadastro realizado com sucesso!");

                    String identificadorUsuario = Base64Custom.codificarBase64(usuarios.getEmail());
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuarios.setId(identificadorUsuario);
                    usuarios.salvar();

                    Preferencias preferencias = new Preferencias(Cadastro.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario, usuarios.getNome());

                    Intent i = new Intent(Cadastro.this, Menu.class);
                    startActivity(i);
                    finish();
                }
                else{
                    String erro = "";

                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erro = "Digite uma senha mais forte";

                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erro = "E-mail inválido";

                    }catch (FirebaseAuthUserCollisionException e){
                        erro = "E-mail já em uso";

                    }catch (Exception e){
                        erro = "Erro ao efetuar o cadastro";
                    }

                    alert(erro);

                }
            }
        });
    }
}
