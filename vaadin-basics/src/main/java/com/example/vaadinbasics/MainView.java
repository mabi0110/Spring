package com.example.vaadinbasics;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/hello")
public class MainView extends VerticalLayout {

    public MainView(){
        add(new Label("Hello world from Vaadin"));
        add(new Label("This is the second line"));


        // We can use HTML and CSS related code to customize
        Span span = new Span("This is a span");
        span.getElement().getStyle().set("font-size", "23px");
        span.getElement().getStyle().set("font-weight", "bold");
        add(span);
        add(new Text("This is a text"));
    }



}
