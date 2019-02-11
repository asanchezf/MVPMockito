package com.antonio.mvpmockito.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by Usuario on 21/02/2018.
 */

@RunWith(MockitoJUnitRunner.class)//Le decimos que vamos a utilizar Mockito...
public class LoginModelTest {


    @Mock//ESTAMOS EN MODEL Y NECESITAMOS QUE NOS LLEGUEN PARÁMETROS DESDE EL PRESENTER
    private Login.Presenter presenter;
    private LoginModel model;

    @Before//ANTES DE EMPEZAR DEBEMOS HACER EJECUTAR UN MÉTODO DONDE SE GENERE UN LOGINMODEL. Como en el constructor de la clase original
    public void setUp() throws Exception{
        model = new LoginModel(presenter);
    }

    @Test//Primer test: se verifica que se haya llamado al método presenter.usuarioValido(): Antonio petylde
    public void usuarioValido() throws Exception{
        model.validaUsuario("Antonio","petylde");
        verify(presenter).usuarioValido();
    }

    @Test//Segundo test: se verifica que se haya llamado el método presenter.error
    public void usuarioInvalido() throws Exception{
        model.validaUsuario("pepe","android");
        verify(presenter).error();
    }

}