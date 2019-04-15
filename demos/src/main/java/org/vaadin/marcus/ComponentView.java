package org.vaadin.marcus;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * ComponentView
 */
@Route("component")
public class ComponentView extends VerticalLayout {

  public ComponentView() {
    BusinessCard businessCard = new BusinessCard();
    businessCard.setName("Marcus");
    businessCard.setTitle("Computer code maker");

    add(businessCard);

    businessCard.getElement().addEventListener("mouseover", e -> {
      System.out.println("'mouseover' event happened");
    });
  }
}