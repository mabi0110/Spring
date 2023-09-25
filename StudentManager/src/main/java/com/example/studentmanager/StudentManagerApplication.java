package com.example.studentmanager;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme(themeClass = Lumo.class)
public class StudentManagerApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagerApplication.class, args);
    }

}
