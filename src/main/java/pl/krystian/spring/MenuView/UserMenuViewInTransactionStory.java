package pl.krystian.spring.MenuView;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Iterator;

@Route("menuIn")
public class UserMenuViewInTransactionStory extends UserMenuView {

    public UserMenuViewInTransactionStory(){
        VerticalLayout verticalLayoutMoneyOut = new VerticalLayout();
        ArrayList temp;
        temp = userInterfaceView.getArrayListOfInTransaction();

        Iterator<String> iterator = temp.iterator();

        while (iterator.hasNext()){
            Label label = new Label(iterator.next().toString());
            verticalLayoutMoneyOut.add(label);
        }

        removeAll();
        add(menuBar, verticalLayoutMoneyOut);
    }
}
