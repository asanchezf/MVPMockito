package com.antonio.mvpmockito.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.antonio.mvpmockito.R;
import com.antonio.mvpmockito.inicio.InicioActivity;

public class LoginActivity extends AppCompatActivity implements Login.View{
    private EditText edtNombre,edtPassword;
    private Login.Presenter mPresenter;//Creamos una variable de clase del tipo interface Login.Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtNombre=findViewById(R.id.edtNombre);
        edtPassword=findViewById(R.id.edtPassword);
        mPresenter=new LoginPresenter(this);
    }

    @Override
    public void usuarioValido() {
        //El usuario se ha logado de manera correcta. Le llevamos al inicio de la app...
        startActivity(new Intent(LoginActivity.this, InicioActivity.class));
    }

    @Override
    public void error() {
        Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUserName() {
        return edtNombre.getText().toString();
    }

    @Override
    public String getPassWord() {
        return edtPassword.getText().toString();
    }

    public void login(View view) {
        mPresenter.validaUsuario(getUserName(),getPassWord());
    }
}
