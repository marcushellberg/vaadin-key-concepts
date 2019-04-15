package org.vaadin.marcus;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.WrapMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("flex")
@StyleSheet("frontend://styles/styles.css")
public class FlexLayoutView extends VerticalLayout {

  public FlexLayoutView() {
    // Instantiate layouts
    HorizontalLayout header = new HorizontalLayout();
    VerticalLayout navBar = new VerticalLayout();
    VerticalLayout content = new VerticalLayout();
    FlexLayout center = new FlexLayout();
    HorizontalLayout footer = new HorizontalLayout();

    // Configure layouts
    setSizeFull();
    setPadding(false);
    setSpacing(false);
    header.setWidth("100%");
    header.setPadding(true);
    center.setWidth("100%");
    center.setWrapMode(WrapMode.WRAP);
    navBar.setMinWidth("200px");
    navBar.getElement().getStyle().set("flex", "1");
    content.setMinWidth("600px");
    content.getElement().getStyle().set("flex", "4");
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