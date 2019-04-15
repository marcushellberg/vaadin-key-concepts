package org.vaadin.marcus;

import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;

@Route("grid")
public class GridView extends VerticalLayout {

  public GridView() {
    this(new AddressBook());
  }

  public GridView(AddressBook addressBook) {
    Grid<Person> grid = new Grid<>();
    grid.addColumn(Person::getFirstName).setHeader("First Name");
    grid.addColumn(Person::getLastName).setHeader("Last Name");
    grid.addColumn(Person::getAge).setHeader("Age");

    // Option 1: In-memory
    List<Person> everyone = addressBook.findAll();
    grid.setItems(everyone);

    // Option 2: Lazy loading
    grid.setDataProvider(DataProvider.fromCallbacks(
        findQuery -> addressBook.find(findQuery.getOffset(), findQuery.getLimit()), countQuery -> addressBook.count()));

    add(grid);
  }
}