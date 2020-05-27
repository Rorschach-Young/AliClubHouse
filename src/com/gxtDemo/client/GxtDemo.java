package com.gxtDemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gxtDemo.client.view.SaveCustomerView;
import com.gxtDemo.client.view.QueryCustomerView;
import com.gxtDemo.client.view.UpdateCustomerView;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CardLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;


/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GxtDemo implements EntryPoint {
    static CardLayoutContainer cardLayout ;
    static VerticalLayoutContainer verticalLtUpdateCustomerView;

    public void onModuleLoad() {
        VerticalLayoutContainer head = new VerticalLayoutContainer();
        ContentPanel panelhead =new ContentPanel();
        head.add(panelhead, new VerticalLayoutContainer.VerticalLayoutData());
        head.setHeight(80);

        cardLayout = new CardLayoutContainer();
        cardLayout.setHeight(1000);
        BorderLayoutContainer borderLtQueryCustomerView = new QueryCustomerView().getBorderLtWidget();
        VerticalLayoutContainer verticalLtSaveCustomerView = new SaveCustomerView().getVerticalLtWidget();
        verticalLtUpdateCustomerView = new UpdateCustomerView().getVerticalLtWidget();

        cardLayout.add(borderLtQueryCustomerView);
        cardLayout.add(verticalLtSaveCustomerView);
        cardLayout.add(verticalLtUpdateCustomerView);

        TabPanel panel = new TabPanel();
        panel.add(cardLayout, new TabItemConfig("客户信息维护"));

        RootPanel.get().add(head);
        RootPanel.get().add(panel);
    }

    public static void back(){
        BorderLayoutContainer borderLtReQueryCustomerView = new QueryCustomerView().getBorderLtWidget();
        cardLayout.setActiveWidget(borderLtReQueryCustomerView);
    }
    public static void save(){
        VerticalLayoutContainer verticalLtSaveCustomerView = new SaveCustomerView().getVerticalLtWidget();
        cardLayout.setActiveWidget(verticalLtSaveCustomerView);
    }
    public static void update(){ cardLayout.setActiveWidget(verticalLtUpdateCustomerView);}

}
