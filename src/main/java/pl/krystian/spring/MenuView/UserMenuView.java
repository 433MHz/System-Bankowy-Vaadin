package pl.krystian.spring.MenuView;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.krystian.spring.MakeTransactionStory;
import pl.krystian.spring.RegisterAndLoginProcess;
import pl.krystian.spring.UserInterfaceView;


@Route("menu")
public class UserMenuView extends HorizontalLayout {
    protected static UserInterfaceView userInterfaceView;
    Label labelCurrentUser = new Label("Witaj " + userInterfaceView.getLogin());
    Button buttonBackToMainPage = new Button("Wróc do menu głównego");
    Button buttonGoToInHistory = new Button("Historia zysków");
    VerticalLayout menuBar = new VerticalLayout();
    Button buttonGoToOutHistory = new Button("Historia strat");
    Button buttonGoToGetHistory = new Button("Historia doładowań");
    Button buttonLogOut = new Button("Wyloguj się");
    VerticalLayout centerBar = new VerticalLayout();
    Label labelMoney = new Label("Posiadasz: " + userInterfaceView.getMoney().toString() + " PLN");
    HorizontalLayout textFieldMoneyLayout = new HorizontalLayout();
    Label labelTextFieldMoneyAdd = new Label("Doładuj pieniądze");
    TextField textFieldMoneyAdd = new TextField();
    Button buttonMoenyAddAccept = new Button("Zatwierdź");
    HorizontalLayout horizontalLayoutSendMoneyToUser = new HorizontalLayout();
    Label labelSendMoney = new Label("Zrób przelew");
    TextField textFieldUserName = new TextField();
    TextField textFieldMoneyToSend = new TextField();
    Button buttonAcceptMoneySendToUser = new Button("Zatwierdź przelew");





    public UserMenuView(){

        buttonBackToMainPage.setWidth("300px");
        buttonBackToMainPage.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate("menu");
        });

        buttonGoToInHistory.setWidth("300px");
        buttonGoToInHistory.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate("menuIn");
        });

        buttonGoToOutHistory.setWidth("300px");
        buttonGoToOutHistory.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate("menuOut");
        });

        buttonGoToGetHistory.setWidth("300px");
        buttonGoToGetHistory.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate("menuGet");
        });

        buttonLogOut.setWidth("300px");
        buttonLogOut.addClickListener(buttonClickEvent -> {
           userInterfaceView = null;
            UI.getCurrent().navigate("");
        });

        menuBar.add(labelCurrentUser, buttonBackToMainPage, buttonGoToInHistory, buttonGoToOutHistory, buttonGoToGetHistory, buttonLogOut);

        textFieldMoneyAdd.setPlaceholder("Używaj tylko liczb");

        buttonMoenyAddAccept.addClickListener(buttonClickEvent -> {
           Double a;
            try{
                if(Double.parseDouble(textFieldMoneyAdd.getValue()) >= 0.0) {
                    a = Double.parseDouble(textFieldMoneyAdd.getValue());
                    textFieldMoneyAdd.clear();
                    userInterfaceView.setMoney(userInterfaceView.getMoney() + a);
                    labelMoney.setText("Posiadasz: " + userInterfaceView.getMoney().toString() + " PLN");
                    MakeTransactionStory.MakeGetTransactionStory(a, userInterfaceView);
                    Notification notification = new Notification("Doładowanie zrealizowano pomyślnie", 3000, Notification.Position.TOP_END);
                    notification.open();
                }
                else{
                    Notification notification = new Notification("Liczby muszą być dodatnie!", 3000, Notification.Position.TOP_END);
                    notification.open();
                }
           }
            catch (Exception ex){
                textFieldMoneyAdd.clear();
                Notification notification = new Notification("Używaj tylko liczb!", 3000, Notification.Position.TOP_END);
                notification.open();
            }
        });

        textFieldMoneyLayout.add(labelTextFieldMoneyAdd ,textFieldMoneyAdd, buttonMoenyAddAccept);

        textFieldUserName.setPlaceholder("Nazwa Użytkownika");

        textFieldMoneyToSend.setPlaceholder("Kwota");

        buttonAcceptMoneySendToUser.addClickListener(buttonClickEvent -> {
           Double a = null;
            try{
               a = Double.parseDouble(textFieldMoneyToSend.getValue());
           }
           catch(Exception ex){
               Notification notification = new Notification("W kwocie możesz używać tylko liczb", 3000, Notification.Position.TOP_END);
               notification.open();
               textFieldMoneyToSend.clear();
            }

           if(a != null){
               if(a > 0.0){
                   if(RegisterAndLoginProcess.getUserInterfaceViewHashMap().containsKey(textFieldUserName.getValue())){
                       if(userInterfaceView.getMoney() - a >= 0.0) {
                           Double b = RegisterAndLoginProcess.getUserInterfaceViewHashMap().get(textFieldUserName.getValue()).getMoney();
                           b = b + a;
                           RegisterAndLoginProcess.getUserInterfaceViewHashMap().get(textFieldUserName.getValue()).setMoney(b);
                           MakeTransactionStory.MakeInTransactionStory(a, RegisterAndLoginProcess.getUserInterfaceViewHashMap().get(textFieldUserName.getValue()), userInterfaceView);
                           MakeTransactionStory.MakeOutTransactionStory(a, userInterfaceView, RegisterAndLoginProcess.getUserInterfaceViewHashMap().get(textFieldUserName.getValue()));
                           userInterfaceView.setMoney(userInterfaceView.getMoney() - a);
                           textFieldUserName.clear();
                           textFieldMoneyToSend.clear();
                           labelMoney.setText("Posiadasz: " + userInterfaceView.getMoney().toString() + " PLN");
                           Notification notification = new Notification("Przelew wykonano pomyślnie", 3000, Notification.Position.TOP_END);
                           notification.open();
                       }
                       else{
                           Notification notification = new Notification("Nie masz wystarczająco dużo środków na koncie", 3000, Notification.Position.TOP_END);
                           notification.open();
                       }
                   }
                   else{
                       Notification notification = new Notification("Nie ma takiego loginu użytkownika", 3000, Notification.Position.TOP_END);
                       notification.open();
                   }
               }
               else{
                   Notification notification = new Notification("Kwota musi być dodatnia", 3000, Notification.Position.TOP_END);
                   notification.open();
               }
           }
           else{

           }
        });

        horizontalLayoutSendMoneyToUser.add(labelSendMoney, textFieldUserName, textFieldMoneyToSend, buttonAcceptMoneySendToUser);

        centerBar.add(labelMoney, textFieldMoneyLayout, horizontalLayoutSendMoneyToUser);
        add(menuBar, centerBar);
    }

    public static void setUserInterfaceView(UserInterfaceView userInterfaceVieww) {
        userInterfaceView = userInterfaceVieww;
    }
}
