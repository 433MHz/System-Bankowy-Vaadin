package pl.krystian.spring.RegisterView;

import com.vaadin.flow.router.Route;
import pl.krystian.spring.RegisterAndLoginProcess;

@Route("registerSuccess")
public class RegisterViewLogSuccesfull extends RegisterViewError {

    public RegisterViewLogSuccesfull() {
        labelError.setText("Zarejestrowano pomyślnie!");
        textFieldLogin.clear();
        passwordFieldPassword.clear();
        passwordFieldPasswordCheck.clear();
    }
}
