package com.example.vaadinbasics;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("/vertical")
@PageTitle("Vertical Layout")
public class VerticalLayoutView extends VerticalLayout {

    public VerticalLayoutView(){

        add(new Button("Button 1"));
        add(new Button("Button 2"));
        add(new Button("Button 3"));
        add(new Button("Button 4"));
        add(new Button("Button 5"));

        setHeight("100%");

        // horizontal alignment
        setAlignItems(FlexComponent.Alignment.CENTER);
//        setAlignItems(FlexComponent.Alignment.STRETCH);

        // vertical alignment
        setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);

    }

}
