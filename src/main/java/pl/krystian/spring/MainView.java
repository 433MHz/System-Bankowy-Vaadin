package pl.krystian.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView(){

        Button buttonGoToLoginPage = new Button("Zaloguj się");
        buttonGoToLoginPage.setWidth("200px");
        buttonGoToLoginPage.addClickListener(buttonClickEvent -> {
            buttonGoToLoginPage.getUI().ifPresent(ui -> ui.navigate("login"));
        });

        Button buttonGoToRegisterPage = new Button("Zarejestruj się");
        buttonGoToRegisterPage.setWidth("200px");
        buttonGoToRegisterPage.addClickListener(buttonClickEvent -> {
           buttonGoToRegisterPage.getUI().ifPresent(ui -> ui.navigate("register"));
        });

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(buttonGoToLoginPage, buttonGoToRegisterPage);
    }

}
