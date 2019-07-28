package pl.krystian.spring;


import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import java.util.ArrayList;


public class UserInterfaceView extends HorizontalLayout {
    private String login;
    private String password;
    private Double money;
    private ArrayList<String> arrayListOfInTransaction = new ArrayList<>();
    private ArrayList<String> arrayListOfOutTransaction = new ArrayList<>();
    private ArrayList<String> arrayListOfGetTransaction = new ArrayList<>();



    public void setLoginPasswordMoney(String loginNew, String passwordNew){
        password = passwordNew;
        login = loginNew;
        money = 0.00;
    }

    public String getPassword() {
        return this.password;
    }

    public String getLogin() {
        return login;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {

        this.money = Math.round(money * 100.0) / 100.0;
    }

    public void setArrayListOfGetTransaction(String getTransaction) {
        arrayListOfGetTransaction.add(getTransaction);
    }

    public void setArrayListOfInTransaction(String inTransaction) {
        arrayListOfInTransaction.add(inTransaction);
    }

    public void setArrayListOfOutTransaction(String outTransaction) {
        arrayListOfOutTransaction.add(outTransaction);
    }

    public ArrayList<String> getArrayListOfGetTransaction() {
        return arrayListOfGetTransaction;
    }

    public ArrayList<String> getArrayListOfInTransaction() {
        return arrayListOfInTransaction;
    }

    public ArrayList<String> getArrayListOfOutTransaction() {
        return arrayListOfOutTransaction;
    }
}
