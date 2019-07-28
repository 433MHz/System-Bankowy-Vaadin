package pl.krystian.spring;

import com.vaadin.flow.component.UI;
import pl.krystian.spring.MenuView.UserMenuView;
import pl.krystian.spring.RegisterView.RegisterView;
import pl.krystian.spring.RegisterView.RegisterViewErrorUserExist;

import java.util.HashMap;

public class RegisterAndLoginProcess {
    private static String login;
    private  static String password;
    private static String passwordCheck;
    private static HashMap<String, UserInterfaceView> userInterfaceViewHashMap = new HashMap<>();

    public static void setLoginPassword(String loginNew, String passwordNew, String passwordCheckNew){
        login = loginNew;
        password = passwordNew;
        passwordCheck = passwordCheckNew;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

    public static String getPasswordCheck() {
        return passwordCheck;
    }

    public static HashMap<String, UserInterfaceView> getUserInterfaceViewHashMap() {
        return userInterfaceViewHashMap;
    }

    public static void registerProcess(){
        if(login.length() >= 6 && login.length() <= 24 && password.length() >= 6 && password.length() <= 24){
            if(passwordCheck.equals(password)){
                if(userInterfaceViewHashMap.containsKey(login)){
                    UI.getCurrent().navigate("registerErrorUserExist");
                }
                else {
                    UserInterfaceView temp = new UserInterfaceView();
                    userInterfaceViewHashMap.put(login, temp);
                    temp.setLoginPasswordMoney(login, password);
                    UI.getCurrent().navigate("registerSuccess");
                }
            }

            else{
                UI.getCurrent().navigate("registerCError");
            }
        }
        else{
            UI.getCurrent().navigate("registerError");
        }
    }

    public static void loginProcess(String loginNew, String passwordNew){
        if(userInterfaceViewHashMap.containsKey(loginNew) && userInterfaceViewHashMap.get(loginNew).getPassword().equals(passwordNew)){
            UserMenuView.setUserInterfaceView(userInterfaceViewHashMap.get(loginNew));
            UI.getCurrent().navigate("menu");
        }
        else{
            UI.getCurrent().navigate("loginError");
        }
    }
}
