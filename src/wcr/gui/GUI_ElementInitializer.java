/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wcr.gui;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Shanshan Chen
 */
public class GUI_ElementInitializer {
    //@todo : prehaps turn this into a singleton class?
    // THIS CLASS USES A SINGLETON DESIGN PATTER, WHICH IS CONVENIENT
    // BECAUSE IT NEEDS TO BE USED BY SO MANY OTHER CLASSES
    static GUI_ElementInitializer singleton;
    
    /**
     * Note that this constructor is private and so can never be called
     * outside of this class.
     */
    private GUI_ElementInitializer() {
        // THIS HELPS US KEEP TRACK OF WHETHER WE NEED TO
        // CONSTRUCT THE SINGLETON OR NOT EACH TIME IT'S ACCESSED
        singleton = null;
    }
    
    /**
     * Accessor method for getting this singleton.
     * 
     * @return The singleton ErrorHandler used by the entire
     * application for responding to error conditions.
     */
    public static GUI_ElementInitializer getInitializer() {
        // INITIALIZE THE SINGLETON ONLY THE FIRST TIME
        if (singleton == null)
            singleton = new GUI_ElementInitializer();
        
        // BUT ALWAYS RETURN IT
        return singleton;
    }
    /*
    // INIT A BUTTON AND ADD IT TO A CONTAINER IN A TOOLBAR
    public Button initChildButton(Pane toolbar, String icon, String tooltip, boolean disabled) {
        String imagePath = "file:" + PATH_IMAGES + props.getProperty(icon.toString());
        Image buttonImage = new Image(imagePath);
        Button button = new Button();
        button.setDisable(disabled);
        button.setGraphic(new ImageView(buttonImage));
        Tooltip buttonTooltip = new Tooltip(props.getProperty(tooltip.toString()));
        button.setTooltip(buttonTooltip);
        toolbar.getChildren().add(button);
        return button;
    }
    
    // INIT A LABEL AND SET IT'S STYLESHEET CLASS
    public Label initLabel(String labelProperty, String styleClass) {
        Label label = new Label(labelProperty);
        label.getStyleClass().add(styleClass);
        return label;
    }

    // INIT A LABEL AND PLACE IT IN A GridPane INIT ITS PROPER PLACE
    public Label initGridLabel(GridPane container, String labelProperty, String styleClass, int col, int row, int colSpan, int rowSpan) {
        Label label = initLabel(labelProperty, styleClass);
        container.add(label, col, row, colSpan, rowSpan);
        return label;
    }

    // INIT A LABEL AND PUT IT IN A TOOLBAR
    public Label initChildLabel(Pane container, String labelProperty, String styleClass) {
        Label label = initLabel(labelProperty, styleClass);
        container.getChildren().add(label);
        return label;
    }
    
    // INIT A LABEL AND RETURN IT
    public Label initChildLabel(String labelProperty, String styleClass) {
        Label label = initLabel(labelProperty, styleClass);
        return label;
    }

    // INIT A COMBO BOX AND PUT IT IN A GridPane
    public ComboBox initGridComboBox(GridPane container, int col, int row, int colSpan, int rowSpan) throws IOException {
        ComboBox comboBox = new ComboBox();
        container.add(comboBox, col, row, colSpan, rowSpan);
        return comboBox;
    }
    
    // INIT A RADIO BUTTON AND PUT IT IN A GridPane
    public RadioButton initGridRadioButton(GridPane container, int col, int row, int colSpan, int rowSpan) throws IOException {
        RadioButton radioButton = new RadioButton();
        container.add(radioButton, col, row, colSpan, rowSpan);
        return radioButton;
    }

    // INIT A TEXT FIELD AND PUT IT IN A GridPane
    public TextField initGridTextField(GridPane container, int size, String initText, boolean editable, int col, int row, int colSpan, int rowSpan) {
        TextField tf = new TextField();
        tf.setPrefColumnCount(size);
        tf.setText(initText);
        tf.setEditable(editable);
        container.add(tf, col, row, colSpan, rowSpan);
        return tf;
    }
    
    // INIT A TEXT FIELD AND PUT IT IN A Pane
    public TextField initChildTextField(Pane container, int size, String initText, boolean editable) {
        TextField tf = new TextField("jkdfhdkjfh");
        //tf.setPrefColumnCount(size);
        tf.setEditable(editable);
        tf.setText(initText);
        container.getChildren().add(tf);
        return tf;
    }

    // INIT A CheckBox AND PUT IT IN A TOOLBAR
    public CheckBox initChildCheckBox(Pane container, String text) {
        CheckBox cB = new CheckBox(text);
        container.getChildren().add(cB);
        return cB;
    }
    */
}
