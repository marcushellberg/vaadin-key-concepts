package org.vaadin.marcus;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

@Route
public class ExampleComponent  extends VerticalLayout {
  private final Binder<Person> binder;
  private BackendService service;

  TextField firstName = new TextField("First Name");
  TextField lastName = new TextField("Last Name");
  Button saveButton = new Button("Save");

  public ExampleComponent(BackendService service) {
    this.service = service;
    add(firstName, lastName, saveButton);
    binder = new Binder<>(Person.class);
    // Bind fields to bean by name
    binder.bindInstanceFields(this);
    saveButton.addClickListener(click -> save());
  }

  public void save() {
    try{
      Person person = new Person();
      binder.writeBean(person);
      service.save(person);
      saveButton.setText("Saved");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }
}
