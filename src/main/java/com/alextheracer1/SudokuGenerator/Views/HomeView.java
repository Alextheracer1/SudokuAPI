package com.alextheracer1.SudokuGenerator.Views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "/")
public class HomeView extends HorizontalLayout {

  private TextField name;
  private Button sayHello;

  public HomeView() {
    setId("hello-world-view");
    name = new TextField("Your name");
    sayHello = new Button("Say hello");
    add(name, sayHello);
    setVerticalComponentAlignment(Alignment.END, name, sayHello);

    // Handle clicks
    sayHello.addClickListener(e -> {
      Notification.show("Hello " + name.getValue());
    });
  }
}
