package org.vaadin.marcus;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BusinessCard extends Composite<VerticalLayout> {
  private Span name = new Span();
  private Span title = new Span();

  public BusinessCard() {
    getContent().add(name, title);
  }

  public void setName(String n) {
    name.setText(n);
  }

  public void setTitle(String t) {
    title.setText(t);
  }
}
