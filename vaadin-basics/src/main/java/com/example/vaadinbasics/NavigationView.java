package com.example.vaadinbasics;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("/navigation")
@PageTitle("Navigation")
public class NavigationView extends VerticalLayout {

    public NavigationView(){
        add(new RouterLink("Show students", ShowStudentView.class));
        add(new RouterLink("Update students", UpdateStudentView.class));
        add(new RouterLink("Remove students", RemoveStudentView.class));

        Button showButton = new Button("Show student view", event -> {
            getUI().ifPresent(ui -> ui.navigate(ShowStudentView.class));
        });

        Button updateButton = new Button("Update student view", event -> {
            getUI().ifPresent(ui -> ui.navigate(UpdateStudentView.class));
        });

        Button removeButton = new Button("Remove student view", event -> {
           getUI().ifPresent(ui -> ui.navigate(RemoveStudentView.class));
        });

        add(showButton, updateButton, removeButton);
    }

}
