package pl.krystian.spring.RegisterView;

import com.vaadin.flow.router.Route;
import pl.krystian.spring.RegisterAndLoginProcess;

@Route("registerError")
public class RegisterViewError extends RegisterView {

    public RegisterViewError(){
        labelError.setText("Sprawdź czy twoje hasło i login mają od 6 do 24 znaków");
        textFieldLogin.setValue(RegisterAndLoginProcess.getLogin());
        passwordFieldPassword.setValue(RegisterAndLoginProcess.getPassword());
        passwordFieldPasswordCheck.setValue(RegisterAndLoginProcess.getPasswordCheck());
        add(labelTopInfo, textFieldLogin, passwordFieldPassword, passwordFieldPasswordCheck, passwordFieldPasswordCheck, labelError, buttonLogIn, buttonBackToMainPage);
    }
}
