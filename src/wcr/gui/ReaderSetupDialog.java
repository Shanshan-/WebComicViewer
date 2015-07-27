/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wcr.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** Dialog to customize the reader
 *
 * @author Shanshan Chen
 */
public class ReaderSetupDialog extends Stage {

    // Other needed classes
    
    // Elements in this dialog
    VBox styleDialogPane;
    Scene styleDialogScene;
    
    //Label styleDialogLabel;
    GridPane settingsGridPane;
    HBox buttonBox;
    
    // Style options elements
    Label fillLabel;
    Pane fillColorPane;
    Button fillColorButton;
    ColorPicker fillColorPicker; 
    Label borderLabel;
    Pane borderColorPane;
    Button borderColorButton;
    ColorPicker borderColorPicker;
    Label imageLabel;
    Button imageChooserButton;
    Label previewLabel;
    Pane previewScreenPane;
    
    // Complete / Cancel button elements
    Button completeButton;
    Button cancelButton;
    String selection;
    
    // Constants
    static final String TITLE = "Add a new style";
    static final String FILL_LABEL_TEXT = "Fill Color:";
    static final String BORDER_LABEL_TEXT = "Border Color:";
    static final String IMAGE_LABEL_TEXT = "Image:";
    static final String PREVIEW_LABEL_TEXT = "Preview:";
    static final String COMPLETE = "Complete";
    static final String CANCEL = "Cancel";
    
    ReaderSetupDialog(Stage owner) {
        // MAKE IT MODAL
        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
        
        //initialize the settings GridPane
        initSettingsPane();
        
        //initialize the buttons and such
        initButtonsToolbar();
        
        //initialize the handlers
        initHandlers();
        
        // arrange big picture items
        styleDialogPane = new VBox();
        styleDialogPane.setAlignment(Pos.CENTER);
        //styleDialogPane.getChildren().add(settingsGridPane);
        styleDialogPane.getChildren().add(buttonBox);
        
        // MAKE IT LOOK NICE
        styleDialogPane.setPadding(new Insets(10, 20, 20, 20));
        styleDialogPane.setSpacing(10);

        // AND PUT IT IN THE WINDOW
        styleDialogScene = new Scene(styleDialogPane);
        this.setScene(styleDialogScene);
    }

    // private helper methods to initialize the gui    
    private void initSettingsPane() {
        /*
    GridPane settingsGridPane;
    
    // Style options elements
    ColorPicker fillColorPicker; 
    ColorPicker borderColorPicker;
    Button imageChooserButton;
    Pane previewScreenPane;
        */
        //initialize the Labels
        fillLabel = new Label("FILL_LABEL_TEXT");
        borderLabel = new Label("BORDER_LABEL_TEXT");
        imageLabel = new Label("IMAGE_LABEL_TEXT");
        previewLabel = new Label("PREVIEW_LABEL_TEXT");
        
        //initialize the 
        
    }

    private void initButtonsToolbar() {
        // initialize and add the buttons
        completeButton = new Button(COMPLETE);
        cancelButton = new Button(CANCEL);
        buttonBox = new HBox();
        buttonBox.getChildren().add(completeButton);
        buttonBox.getChildren().add(cancelButton);
    }
    
    private void initHandlers() {
        //register event handlers for the style options
        //fillColorPicker.setOnAction(e -> {
            
        //});
        //borderColorPicker.setOnAction(e -> {
            
        //});
        //imageChooserButton.setOnAction(e -> {
            
        //});
        
        // REGISTER EVENT HANDLERS FOR OUR COMPLETE/CANCEL BUTTONS
        EventHandler completeCancelHandler = (EventHandler<ActionEvent>) (ActionEvent ae) -> {
            Button sourceButton = (Button)ae.getSource();
            ReaderSetupDialog.this.selection = sourceButton.getText();
            ReaderSetupDialog.this.hide();
        };
        completeButton.setOnAction(completeCancelHandler);
        cancelButton.setOnAction(completeCancelHandler);
    }
}
