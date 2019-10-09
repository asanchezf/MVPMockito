package com.antonio.mvpmockito.login;



public class LoginPresenter implements Login.Presenter {
    //El Presenter hará de puente entre el View y el Modelo...
    //Se crean dos variables miembro que pertenecientes a interfaces View y Model
    private Login.View mView;
    private Login.Model mModel;

    public LoginPresenter(Login.View view) {
        //Recogemos la variable view y la igualamos a la nuestra y además creamos un ejemplar de la clae LoginModel()
        mView = view;
        mModel = new LoginModel(this);
    }

    @Override
    public void validaUsuario(String user, String pass) {
        //Una vez validado que view no es nulo enviamos los parámetros user y pass al Modelo para que los valide
        if(mView!=null){
            mModel.validaUsuario(user,pass);
        }

    }

    @Override
    public void usuarioValido() {
        //Es un método que retorna a la view para informarle de que el usuario se ha logado correctamente
        if(mView!=null){
            mView.usuarioValido();

        }
    }

    @Override
    public void error() {
        //Es un método para informarle a la view de que el usuario no ha conseguido logarse correctamente.
        if(mView!=null){
            mView.error();
        }
    }
}
