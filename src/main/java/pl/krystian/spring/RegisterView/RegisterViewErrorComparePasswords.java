package pl.krystian.spring.RegisterView;

import com.vaadin.flow.router.Route;

@Route("registerCError")
public class RegisterViewErrorComparePasswords extends RegisterViewError {

    public RegisterViewErrorComparePasswords(){
        labelError.setText("Sprawdź czy hasła są takie same");
    }

}
