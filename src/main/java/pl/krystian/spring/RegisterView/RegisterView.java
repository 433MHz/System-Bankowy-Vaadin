package pl.krystian.spring.RegisterView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.krystian.spring.RegisterAndLoginProcess;

@Route("register")
public class RegisterView extends VerticalLayout {
    Label labelTopInfo = new Label("Zarejestruj się!");
    Label labelError = new Label("Sprawdź czy twoje hasło i login mają od 6 do 24 znaków");
    TextField textFieldLogin = new TextField("Login");
    PasswordField passwordFieldPassword = new PasswordField("Hasło");
    PasswordField passwordFieldPasswordCheck = new PasswordField("Potwierdź hasło");
    Button buttonLogIn = new Button("Zarejestruj się");
    Button buttonBackToMainPage = new Button("Wróc do strony głównej");

    public RegisterView(){
        buttonBackToMainPage.setWidth("230px");
        buttonBackToMainPage.addClickListener(buttonClickEvent -> {
           buttonBackToMainPage.getUI().ifPresent(ui -> ui.navigate(""));
        });

        buttonLogIn.setWidth("230px");
        buttonLogIn.addClickListener(buttonClickEvent -> {
           RegisterAndLoginProcess.setLoginPassword(textFieldLogin.getValue(), passwordFieldPassword.getValue(), passwordFieldPasswordCheck.getValue());
           RegisterAndLoginProcess.registerProcess();
        });

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(labelTopInfo, textFieldLogin, passwordFieldPassword, passwordFieldPasswordCheck, buttonLogIn, buttonBackToMainPage);
    }

}
