package com.antonio.mvpmockito.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Usuario on 21/02/2018.
 */


@RunWith(MockitoJUnitRunner.class)//Le decimos que vamos a utilizar Mockito...
public class LoginPresenterTest {
    //VER: https://www.youtube.com/watch?v=qkwZ6DItaNo&list=PLN5jmnTStJNi-E0Vm4nr4_2VllWS4LFeu&index=4
//NOS FIJAMOS EN LA CONSTRUCCIÓN DE LA CLASE ORIGINAL
//Estamos en el Presenter. Mockeamos la view y el modelo. Igual que en la clase original
    @Mock
    private Login.View view;
    @Mock
    private Login.Model model;

    private LoginPresenter presenter;

    @Before//ANTES DE EMPEZAR DEBEMOS HACER EJECUTAR UN MÉTODO DONDE SE GENERE UN LOGINPRESENTER. Como en el constructor de la clase original
    public void setUt() throws Exception{
        presenter = new LoginPresenter(view);
    }


    @Test//Testeamos cuando el usuario y la contrseñas son correctos. Por eso se debe ejecutar el método view.usuarioValido()
    public void cuandoUsuarioValido() throws Exception{
        when(view.getUserName()).thenReturn("Antonio");//Le decimos q queremos que el método getUserName de la view nos devuelva Antonio...
        when(view.getPassWord()).thenReturn("petylde");//Le decimos q queremos que el método getPassWord de la view nos devuelva petylde...
        presenter.validaUsuario(view.getUserName(),view.getPassWord());//Le decimos que se ejecute presenter.validaUsuario()
        verify(view).usuarioValido();//Como el resultado ese correcto se debe ejecutar view.usuarioValido()
    }


    @Test//Testeamos cuando el usuario y la contrseñas son incorrecto. Por eso se debe ejecutar el método view.error()
    public void cuandoUsuarioInvalido() throws Exception{
        when(view.getUserName()).thenReturn("Pepe");//Le decimos q queremos que el método getUserName de la view nos devuelva Antonio...
        when(view.getPassWord()).thenReturn("petylde");//Le decimos q queremos que el método getPassWord de la view nos devuelva petylde...
        presenter.validaUsuario(view.getUserName(),view.getPassWord());//Le decimos que se ejecute presenter.validaUsuario()
        verify(view).error();//Como el resultado ese correcto se debe ejecutar view.error()
    }





}