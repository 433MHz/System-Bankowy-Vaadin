package pl.krystian.spring.MenuView;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Iterator;

@Route("menuGet")
public class UserMenuViewGetTransactionStory extends UserMenuView {

    public UserMenuViewGetTransactionStory(){
        VerticalLayout verticalLayoutMoneyOut = new VerticalLayout();
        ArrayList temp;
        temp = userInterfaceView.getArrayListOfGetTransaction();

        Iterator<String> iterator = temp.iterator();

        while (iterator.hasNext()){
            Label label = new Label(iterator.next().toString());
            verticalLayoutMoneyOut.add(label);
        }

        removeAll();
        add(menuBar, verticalLayoutMoneyOut);
    }
}
