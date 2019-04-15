package org.vaadin.marcus;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.Route;

@Route("forms")
public class FormView extends FormLayout {

  public FormView() {
    Person model = new Person();

    TextField firstNameField = new TextField("First Name");
    TextField ageField = new TextField("Age in years");
    Binder<Person> binder = new Binder<>(Person.class);

    binder.forField(firstNameField).asRequired()
        .withValidator(name -> name.equals("Marcus"), "Your name should be Marcus")
        .bind(Person::getFirstName, Person::setFirstName);

    binder.forField(ageField).asRequired().withConverter(new StringToIntegerConverter("Age must be a number"))
        .withValidator(age -> age > 2, "How are you using a computer?").bind(Person::getAge, Person::setAge);

    Div statusLabel = new Div();
    binder.setStatusLabel(statusLabel);
    binder.withValidator(person -> person.getFirstName().equals("Marcus") && person.getLastName().equals("Hellberg"),
        "Ha! You have the correct first name, but wrong last name. Better luck next time!");

    // One-way binding
    binder.readBean(model);

    // Two-way binding
    binder.setBean(model);

    try {
      Person saved = new Person();
      binder.writeBean(saved);
      // Persist saved bean
    } catch (ValidationException e) {
      // show errors to user
    }
  }
}