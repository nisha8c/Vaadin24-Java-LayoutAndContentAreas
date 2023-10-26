package com.example.application.views.headerfooter;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("headerfooter")
@Route(value = "my-view3", layout = MainLayout.class)
@Uses(Icon.class)
public class HeaderfooterView extends Composite<VerticalLayout> {

    public HeaderfooterView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        H2 h2 = new H2();
        Select select = new Select();
        ComboBox comboBox = new ComboBox();
        Icon icon = new Icon();
        Icon icon2 = new Icon();
        Icon icon3 = new Icon();
        Icon icon4 = new Icon();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        DatePicker datePicker = new DatePicker();
        TimePicker timePicker = new TimePicker();
        Button buttonPrimary = new Button();
        ComboBox comboBox2 = new ComboBox();
        TextField textField = new TextField();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Grid stripedGrid = new Grid(SamplePerson.class);
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        H6 h6 = new H6();
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow2.setHeightFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.setAlignItems(Alignment.END);
        layoutRow2.setJustifyContentMode(JustifyContentMode.END);
        h2.setText("Testing");
        layoutRow2.setFlexGrow(1.0, h2);
        layoutRow2.setAlignSelf(FlexComponent.Alignment.END, h2);
        select.setLabel("Select");
        setSelectSampleData(select);
        comboBox.setLabel("Combo Box");
        layoutRow2.setFlexGrow(1.0, comboBox);
        layoutRow2.setAlignSelf(FlexComponent.Alignment.END, comboBox);
        setComboBoxSampleData(comboBox);
        icon.getElement().setAttribute("icon", "lumo:user");
        icon2.getElement().setAttribute("icon", "lumo:user");
        icon3.getElement().setAttribute("icon", "lumo:user");
        icon4.getElement().setAttribute("icon", "lumo:user");
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.setWidthFull();
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutColumn2.setHeightFull();
        layoutColumn2.setWidth(null);
        checkboxGroup.setLabel("Checkbox Group");
        checkboxGroup.setItems("Order ID", "Product Name", "Customer", "Status");
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        datePicker.setLabel("Date picker");
        timePicker.setLabel("Time picker");
        buttonPrimary.setText("Button");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        comboBox2.setLabel("Combo Box");
        setComboBoxSampleData(comboBox2);
        textField.setLabel("Text field");
        layoutRow3.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setHeightFull();
        layoutColumn3.setWidth(null);
        stripedGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        setGridSampleData(stripedGrid);
        layoutRow4.setWidthFull();
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow5.setHeightFull();
        layoutRow4.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setAlignItems(Alignment.START);
        layoutRow5.setJustifyContentMode(JustifyContentMode.END);
        h6.setText("footer text");
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(h2);
        layoutRow2.add(select);
        layoutRow2.add(comboBox);
        layoutRow2.add(icon);
        layoutRow2.add(icon2);
        layoutRow2.add(icon3);
        layoutRow2.add(icon4);
        getContent().add(layoutRow3);
        layoutRow3.add(layoutColumn2);
        layoutColumn2.add(checkboxGroup);
        layoutColumn2.add(datePicker);
        layoutColumn2.add(timePicker);
        layoutColumn2.add(buttonPrimary);
        layoutColumn2.add(comboBox2);
        layoutColumn2.add(textField);
        layoutRow3.add(layoutColumn3);
        layoutColumn3.add(stripedGrid);
        getContent().add(layoutRow4);
        layoutRow4.add(layoutRow5);
        layoutRow5.add(h6);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
