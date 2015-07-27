/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wcr.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import wcr.gui.ReaderSetupDialog;
import wcr.gui.WCR_GUI;

/**
 *
 * @author Shanshan Chen
 */
public class ComicController {

    File prevDirectory = null;
    
    public void handleNewComicRequest(WCR_GUI gui) {
        // AND NOW ASK THE USER FOR THE COURSE TO OPEN
        DirectoryChooser comicDirectoryChooser = new DirectoryChooser();
        if(prevDirectory != null)
            comicDirectoryChooser.setInitialDirectory(prevDirectory);
        File selectedFile = comicDirectoryChooser.showDialog(gui.getWindow());

        // ONLY OPEN A NEW FILE IF THE USER SAYS OK
        if (selectedFile != null) {
            try {
                prevDirectory = selectedFile;
                String[] imageList = loadImageNames(selectedFile);
                gui.loadImages(imageList);
            } catch (Exception e) {
                System.out.println("Error message: " + e.getMessage());
                System.out.println("String version: " + e.toString());
                System.out.println("Error occured in loading file" + selectedFile);
            }
        }
    }

    public void handleNewStyleRequest(WCR_GUI aThis, ReaderSetupDialog styleDialog) {
    }

    public void handleChangeStyleRequest(WCR_GUI aThis) {
    }
    
    private void promptToOpen(WCR_GUI gui) {
        
    }

    private String[] loadImageNames(File directory) throws MalformedURLException {
        File[] files = directory.listFiles();
        String[] urls = new String[files.length];
        for(int x = 0 ; x < files.length ; x++)
            urls[x] = files[x].toURL().toString();
        return urls;
    }

}
