/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sceneControllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.animation.TranslateTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Natalia
 */
public class CategoryPaneController extends BaseView implements Initializable {

    final int GRIDPANE_COLUMNS_NUMBER = 3;
    final int ANIMATION_DURATION = 275;
    final int ANIMATION_DISTANCE = 700;
    final String PRODUCT_PANE_LOCATION ="/view/scene/productsPane.fxml";
    @FXML
    private BorderPane storeMainPane;
    @FXML
    private GridPane categoryContainer;
    
    private Node productsPane = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commController.setCategoryPaneController(this);
        
        ArrayList<HashMap<String,Object>> categories =  this.controllerForView.getAll("category");
        categories.forEach((category) -> {
            try{
                this.addCategory(category);
            }catch (IOException ex){
                Logger.getLogger(CategoryPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    

    public void addCategory(HashMap<String,Object> category) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/scene/category.fxml"));
        Node categoryNode = loader.load();
        CategoryController categoryContr = loader.getController();
        categoryContr.setCategoryInfo(category);
        int index = categoryContainer.getChildren().size();
        int columnIndex = index%this.GRIDPANE_COLUMNS_NUMBER;
        int rowIndex = (int) Math.floor(index/this.GRIDPANE_COLUMNS_NUMBER);
        categoryContainer.add(categoryNode, columnIndex, rowIndex);
        this.animate();
    }

    @FXML
    private void addCategoryButtonClicked(ActionEvent event) throws IOException {
        BorderPane dashboardBorderPane = (BorderPane) storeMainPane.getParent();
        dashboardBorderPane.setRight(FXMLLoader.load(getClass().getResource("/view/scene/addCategory.fxml")));
    }
    
    public void showProductsForCategory(String category) throws IOException{
        if(this.productsPane == null){
            this.productsPane = FXMLLoader.load(getClass().getResource(this.PRODUCT_PANE_LOCATION));
        }
        ProductsPaneController productsPaneContr = commController.getProductsPaneController();
        productsPaneContr.emptyProductInfo();
        productsPaneContr.loadProductsByCategory(category);
        BorderPane dashboardBorderPane = (BorderPane) storeMainPane.getParent();
        dashboardBorderPane.setCenter(productsPane);
        dashboardBorderPane.setRight(null);
    }

    public void animate(){
        List<Node> categories = categoryContainer.getChildren();
        for(Node category: categories){
            TranslateTransition t = new TranslateTransition(Duration.millis(this.ANIMATION_DURATION), category);
            t.setFromX(this.ANIMATION_DISTANCE);
            t.setToX(0);
            t.play();
        }
    }
    
}