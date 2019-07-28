package pl.krystian.spring.LoginView;


import com.vaadin.flow.router.Route;

@Route("loginError")
public class LoginViewError extends LoginView {

    public LoginViewError(){
        add(labelTopInfo, textFieldLogin, passwordFieldPassword, error, buttonLogIn, buttonBackToMainPage);
    }
}
