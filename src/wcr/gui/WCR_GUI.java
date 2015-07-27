/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wcr.gui;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import wcr.controller.ComicController;

/** The class used to create the main body of the reader
 *
 * @author Shanshan Chen
 */
public class WCR_GUI {

    //needed seperate classes
    ComicController controller;
    
    //Main stage of this application and screen
    Stage primaryStage;
    Scene primaryScene;
    
    //Related dialogs
    ReaderSetupDialog styleDialog;
    
    //GUI Elements
    BorderPane wcrScreen;
    ScrollPane comicDisplayScrollPane;
    VBox comicDisplayBox;
    
    //Top toolbar GUI items
    FlowPane topToolbar;
    Button loadComicButton;
    ComboBox defaultStylesComboBox;
    Button createStyleButton;
    
    //other global constants
    double screenWidth;
    
    public WCR_GUI(Stage stage) {
        primaryStage = stage;
        controller = new ComicController();
    }
    
    public void initGUI(String windowTitle) {
        //initialize the necessary dialogs
        initDialogs();
        
        //initialize the screen
        initReader();
        
        //initialize the event handlers
        initHandlers();
        
        //initialize the window
        initWindow(windowTitle);
    }
    
    private void initDialogs() {
        styleDialog = new ReaderSetupDialog(primaryStage);
    }
    
    private void initReader() {
        //initialize the overall container
        wcrScreen = new BorderPane();
        
        //initialize the top toolbar
        topToolbar = new FlowPane();
        loadComicButton = initChildButton(topToolbar, "NewComic.png", "Choose a new comic to load", false);
        defaultStylesComboBox = new ComboBox();
        topToolbar.getChildren().add(defaultStylesComboBox);
        createStyleButton = initChildButton(topToolbar, "AddStyle.png", "Choose a style for the reader", false);
        
        //initialize the reader pane
        comicDisplayScrollPane = new ScrollPane();
        //comicDisplayScrollPane.setFitToWidth(true);
        comicDisplayBox = new VBox();
        comicDisplayBox.setAlignment(Pos.TOP_CENTER);
        comicDisplayScrollPane.setContent(comicDisplayBox);
        
        //place the components into the overall container
        wcrScreen.setTop(topToolbar);
        wcrScreen.setCenter(comicDisplayScrollPane);
    }
    
    // INIT A BUTTON AND ADD IT TO A CONTAINER IN A TOOLBAR
    private Button initChildButton(Pane toolbar, String icon, String tooltip, boolean disabled) {
        String imagePath = "file:" + "./images/" + icon;
        Image buttonImage = new Image(imagePath);
        Button button = new Button();
        button.setDisable(disabled);
        button.setGraphic(new ImageView(buttonImage));
        Tooltip buttonTooltip = new Tooltip(tooltip);
        button.setTooltip(buttonTooltip);
        toolbar.getChildren().add(button);
        return button;
    }
    
    private void initHandlers() {
        loadComicButton.setOnAction(e -> {
            controller.handleNewComicRequest(this);
        });
        createStyleButton.setOnAction(e -> {
            controller.handleNewStyleRequest(this, styleDialog);
        });
        defaultStylesComboBox.setOnAction(e -> {
            controller.handleChangeStyleRequest(this);
        });
    }
    
    // INITIALIZE THE WINDOW (i.e. STAGE) PUTTING ALL THE CONTROLS THERE 
    private void initWindow(String windowTitle) {
        // SET THE WINDOW TITLE
        primaryStage.setTitle(windowTitle);

        // GET THE SIZE OF THE SCREEN
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // AND USE IT TO SIZE THE WINDOW
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        comicDisplayScrollPane.setMaxWidth(bounds.getWidth());

        primaryScene = new Scene(wcrScreen);
        screenWidth = bounds.getWidth();


        // NOW TIE THE SCENE TO THE WINDOW, SELECT THE STYLESHEET
        // WE'LL USE TO STYLIZE OUR GUI CONTROLS, AND OPEN THE WINDOW
        //primaryScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    public Stage getWindow() {
        return primaryStage;
    }

    public void loadImages(String[] imageList) {
        //@todo setup to arrange files by number beyond lexigraphical order
        for(String s : imageList)
            loadImage(comicDisplayBox, s);
    }
    
    public Image loadImage(Pane container, String path) {
        Image image = new Image(path);
        ImageView pane = new ImageView(image);
        pane.setPreserveRatio(true);
        container.getChildren().add(pane);
        if(image.getWidth() > screenWidth - 50)
            pane.setFitWidth(screenWidth - 50);
        return image;
    }
    
}
