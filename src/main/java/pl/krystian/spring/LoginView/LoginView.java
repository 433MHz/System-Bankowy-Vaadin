package pl.krystian.spring.LoginView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.krystian.spring.RegisterAndLoginProcess;


@Route("login")
public class LoginView extends VerticalLayout {
    Label labelTopInfo = new Label("Zaloguj się!");
    Label error = new Label("Niewłaściwy login lub hasło");
    TextField textFieldLogin = new TextField("Login");
    PasswordField passwordFieldPassword = new PasswordField("Hasło");
    Button buttonLogIn = new Button("Zaloguj się");
    Button buttonBackToMainPage = new Button("Wróc do strony głównej");


    public LoginView(){
        buttonBackToMainPage.setWidth("230px");
        buttonBackToMainPage.addClickListener(buttonClickEvent -> {
            buttonBackToMainPage.getUI().ifPresent(ui -> ui.navigate(""));
        });

        buttonLogIn.setWidth("230px");
        buttonLogIn.addClickListener(buttonClickEvent -> {
            RegisterAndLoginProcess.loginProcess(textFieldLogin.getValue(), passwordFieldPassword.getValue());
        });

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(labelTopInfo, textFieldLogin, passwordFieldPassword, buttonLogIn, buttonBackToMainPage);
    }
}
