package org.vaadin.marcus;

import com.vaadin.flow.component.ClickEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ExampleComponentTest {

  private ExampleComponent component;
  private BackendService serviceMock;

  @BeforeEach
  void setUp() {
    serviceMock = Mockito.mock(BackendService.class);
    component = new ExampleComponent(serviceMock);
  }

  @Test
  void save() {
    component.firstName.setValue("Marcus");
    component.lastName.setValue("Hellberg");

    component.save();

    // Person.equals is based on names in this example
    Mockito.verify(serviceMock).save(new Person("Marcus", "Hellberg"));
  }
}