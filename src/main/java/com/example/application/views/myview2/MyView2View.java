package com.example.application.views.myview2;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("My View2")
@Route(value = "my-view2", layout = MainLayout.class)
@Uses(Icon.class)
public class MyView2View extends Composite<VerticalLayout> {

    public MyView2View() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        LoginForm loginForm = new LoginForm();
        Accordion accordion = new Accordion();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        MenuBar menuBar = new MenuBar();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Grid stripedGrid = new Grid(SamplePerson.class);
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutColumn2.setHeightFull();
        layoutColumn2.setWidth(null);
        setAccordionSampleData(accordion);
        layoutRow2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        setMenuBarSampleData(menuBar);
        layoutRow.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setHeightFull();
        layoutColumn3.setWidth(null);
        stripedGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        setGridSampleData(stripedGrid);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(loginForm);
        layoutColumn2.add(accordion);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(menuBar);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(stripedGrid);
    }

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

    private void setMenuBarSampleData(MenuBar menuBar) {
        menuBar.addItem("View");
        menuBar.addItem("Edit");
        menuBar.addItem("Share");
        menuBar.addItem("Move");
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
