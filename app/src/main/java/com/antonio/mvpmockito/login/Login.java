package com.antonio.mvpmockito.login;

/**
 * Interface que contiene otras interfaces para la creacón de una arquitectura MVP en el Proyecto
 */

public interface Login {

    //Será implementado en la vista
    interface View{
        void usuarioValido();//Lo que haremos si el usuario se ha logado con éxito.
        void error();//Lo que haremos si el usuario no se ha logado
        String getUserName();
        String getPassWord();

    }

    //Será implementado en el Presenter
    interface Presenter{
        void validaUsuario(String user,String pass);
        void usuarioValido();
        void error();
    }

    //Será implementado en el modelo
    interface Model{
        void validaUsuario(String user,String pass);

    }
}
