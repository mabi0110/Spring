package com.example.vaadinbasics;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/dialog")
@PageTitle(("Dialog View"))
public class DialogView extends VerticalLayout {

    private TextField nameField;
    private TextField ageField;

    public DialogView(){

        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Add new student");

        VerticalLayout dialogLayout = createDialogLayout();

        Button closeButton = new Button("Cancel", event -> dialog.close());
        Button saveButton = new Button("Save", event -> {
            System.out.println(nameField.getValue() + " - " + ageField.getValue());
            dialog.close();
        });

        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        dialog.add(dialogLayout);
        dialog.getFooter().add(closeButton);
        dialog.getFooter().add(saveButton);

        // button for showing the dialog
        Button button = new Button("Show dialog", event-> dialog.open());
        add(dialog, button);
    }


    private VerticalLayout createDialogLayout() {
        nameField = new TextField("Student name");
        ageField = new TextField("Student age");

        VerticalLayout layout = new VerticalLayout(nameField, ageField);
        layout.getStyle().set("width", "250px").set("max-width", "100%");

        return layout;
    }


}
