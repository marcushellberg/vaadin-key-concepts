package org.vaadin.marcus;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(SampleView.NAME)
public class SampleView extends VerticalLayout {
  public static final String NAME = "sample";

  public SampleView() {
    add(new H1("I am a sample view"));
  }
}