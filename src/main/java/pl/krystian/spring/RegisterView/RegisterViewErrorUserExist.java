package pl.krystian.spring.RegisterView;

import com.vaadin.flow.router.Route;

@Route("registerErrorUserExist")
public class RegisterViewErrorUserExist extends RegisterViewError {

    public RegisterViewErrorUserExist(){
        labelError.setText("Taki login jest już zajęty");
    }
}
