package com.renanclimeni.appmellito.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.renanclimeni.appmellito.firebase.FirebaseConfig;

import java.util.HashMap;
import java.util.Map;

public class Usuarios {
    private String id;
    private String nome;
    private String email;

    public String getId() {
        return id;
    }

    public Usuarios() {
    }

    public void salvar(){
        DatabaseReference referenciaFirebase = FirebaseConfig.getFirebase();
        referenciaFirebase.child("usuarios").child(String.valueOf(getId())).setValue(this);
    }

    @Exclude

    public Map<String, Object> toMap(){
        HashMap<String, Object> hashMapUsuario = new HashMap<>();

        hashMapUsuario.put("id", getId());
        hashMapUsuario.put("nome", getNome());
        hashMapUsuario.put("email", getEmail());
        hashMapUsuario.put("senha", getSenha());

        return hashMapUsuario;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

}
