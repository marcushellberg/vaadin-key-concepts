package org.vaadin.marcus;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("basic")
@StyleSheet("frontend://styles/styles.css")
public class BasicLayoutView extends VerticalLayout {

  public BasicLayoutView() {
    // Instantiate layouts
    HorizontalLayout header = new HorizontalLayout();
    VerticalLayout navBar = new VerticalLayout();
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout center = new HorizontalLayout();
    HorizontalLayout footer = new HorizontalLayout();

    // Configure layouts
    setSizeFull();
    setPadding(false);
    setSpacing(false);
    header.setWidth("100%");
    header.setPadding(true);
    center.setWidth("100%");
    navBar.setWidth("200px");
    content.setWidth("100%");
    footer.setWidth("100%");
    footer.setPadding(true);

    // Compose layout
    center.add(navBar, content);
    center.setFlexGrow(1, navBar);
    add(header, center, footer);
    expand(center);

    // not for tutorial
    header.addClassName("header");
    header.add(new Span("Header"));
    navBar.addClassName("navbar");
    navBar.add(new Span("Navigation"));
    content.addClassName("content");
    content.add(new Span("Content"));
    footer.addClassName("footer");
    footer.add(new Span("Footer"));
  }
}
