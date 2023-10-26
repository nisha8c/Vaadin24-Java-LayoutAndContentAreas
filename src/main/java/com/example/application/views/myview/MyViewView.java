package com.example.application.views.myview;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("My View")
@Route(value = "my-view", layout = MainLayout.class)
@Uses(Icon.class)
public class MyViewView extends Composite<VerticalLayout> {

    public MyViewView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Span badge = new Span();
        RouterLink routerLink = new RouterLink();
        TextField textField = new TextField();
        Span badge2 = new Span();
        Grid multiSelectGrid = new Grid(SamplePerson.class);
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Accordion accordion = new Accordion();
        LoginForm loginForm = new LoginForm();
        LoginForm loginForm2 = new LoginForm();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidthFull();
        layoutColumn2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth(null);
        badge.setText("Badge");
        badge.getElement().getThemeList().add("badge");
        routerLink.setText("Custom View");
        routerLink.setRoute(MyViewView.class);
        textField.setLabel("Text field");
        badge2.setText("Badge");
        badge2.getElement().getThemeList().add("badge");
        multiSelectGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        setGridSampleData(multiSelectGrid);
        layoutColumn3.setHeightFull();
        layoutColumn3.setWidth(null);
        setAccordionSampleData(accordion);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(badge);
        layoutColumn2.add(routerLink);
        layoutColumn2.add(textField);
        layoutColumn2.add(badge2);
        layoutColumn2.add(multiSelectGrid);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(accordion);
        layoutColumn3.add(loginForm);
        layoutColumn3.add(loginForm2);
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;

    private void setAccordionSampleData(Accordion accordion) {
        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");
        VerticalLayout personalInformationLayout = new VerticalLayout(name, email, phone);
        personalInformationLayout.setSpacing(false);
        personalInformationLayout.setPadding(false);
        accordion.add("Personal information", personalInformationLayout);
        Span street = new Span("4027 Amber Lake Canyon");
        Span zipCode = new Span("72333-5884 Cozy Nook");
        Span city = new Span("Arkansas");
        VerticalLayout billingAddressLayout = new VerticalLayout();
        billingAddressLayout.setSpacing(false);
        billingAddressLayout.setPadding(false);
        billingAddressLayout.add(street, zipCode, city);
        accordion.add("Billing address", billingAddressLayout);
        Span cardBrand = new Span("Mastercard");
        Span cardNumber = new Span("1234 5678 9012 3456");
        Span expiryDate = new Span("Expires 06/21");
        VerticalLayout paymentLayout = new VerticalLayout();
        paymentLayout.setSpacing(false);
        paymentLayout.setPadding(false);
        paymentLayout.add(cardBrand, cardNumber, expiryDate);
        accordion.add("Payment", paymentLayout);
    }
}
