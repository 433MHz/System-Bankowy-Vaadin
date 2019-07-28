package pl.krystian.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeTransactionStory {

public static void MakeInTransactionStory(Double money, UserInterfaceView user, UserInterfaceView userOther){
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    UserInterfaceView userInterfaceView = user;
    UserInterfaceView userInterfaceViewOther = userOther;
    String temp = simpleDateFormat.format(new Date());
    temp = temp + "  ----->  " + (Math.round(money * 100.0) / 100.0) + " PLN    Przelane od użytkownika    " + userInterfaceViewOther.getLogin();
    userInterfaceView.setArrayListOfInTransaction(temp);
}

    public static void MakeOutTransactionStory(Double money, UserInterfaceView user, UserInterfaceView userOther){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        UserInterfaceView userInterfaceView = user;
        UserInterfaceView userInterfaceViewOther = userOther;
        String temp = simpleDateFormat.format(new Date());
        temp = temp + "  ----->  -" + (Math.round(money * 100.0) / 100.0) + " PLN    Przelane do użytkownika    " + userInterfaceViewOther.getLogin();
        userInterfaceView.setArrayListOfOutTransaction(temp);
    }

    public static void MakeGetTransactionStory(Double money, UserInterfaceView user){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        UserInterfaceView userInterfaceView = user;
        String temp = simpleDateFormat.format(new Date());
        temp = temp + "  ----->  " + (Math.round(money * 100.0) / 100.0) + " PLN";
        userInterfaceView.setArrayListOfGetTransaction(temp);
    }
}
