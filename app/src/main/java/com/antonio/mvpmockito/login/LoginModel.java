package com.antonio.mvpmockito.login;

public class LoginModel implements Login.Model{

    private Login.Presenter mPresenter;

    public LoginModel(Login.Presenter presenter) {
        mPresenter = presenter;
    }



    @Override
    public void validaUsuario(String user, String pass) {
        //Si introducen los valores correctos...
        if(user.equalsIgnoreCase("Antonio") && pass.equalsIgnoreCase("petylde")){
            mPresenter.usuarioValido();
        }else mPresenter.error();


    }
}
