/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sceneControllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Natalia
 */
public class CategoryController extends BaseView implements Initializable {

    final String TOTAL_PROD_IN_CATEGORY_LABEL = "Totale prodotti:";
    final String LAST_ORDER_LABEL = "Ultimo ordine:";
    final String MONTHLY_EXPENSE_LABEL = "Spesa media mensile:";

    public Label categoryLabel;
    public ImageView categoryIcon;
    public Label totalProductsInCategoryLabel;
    public Label lastOrderLabel;
    public Label monthlyExpenseLabel;
    public Label lastOrderValue;
    public Label monthlyExpenseValue;
    public Label totalProductsInCategoryValue;
    public AnchorPane categoryContainer;
    private HashMap<String, Object> category;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setCategoryInfo(HashMap<String, Object> category){
        this.category = category;
        String name = (String)category.get("name");
        this.categoryLabel.setText(name.substring(0, 1).toUpperCase() + name.substring(1));
        if (category.get("img") != null){
            this.categoryIcon.setImage(imagesProvider.getCategoryImage(category.get("name").toString()));
        }
        HashMap<String, Object> categoryInfo = (HashMap<String, Object>) category.get("info");
        this.initializeLabels();
        if(categoryInfo != null){
            if(categoryInfo.get("productsTotal") != null){
                this.totalProductsInCategoryValue.setText(categoryInfo.get("productsTotal").toString());
            }
            if(categoryInfo.get("lastOrder") != null){
                this.lastOrderValue.setText(categoryInfo.get("lastOrder").toString());
            }
            if(categoryInfo.get("averageExpense") != null){
                Double floor = Math.floor((Double)categoryInfo.get("averageExpense"));
                this.monthlyExpenseValue.setText(floor.toString());
            }
        }
    }

    private void initializeLabels(){
        this.totalProductsInCategoryLabel.setText(this.TOTAL_PROD_IN_CATEGORY_LABEL + " ");
        this.lastOrderLabel.setText(this.LAST_ORDER_LABEL + " ");
        this.monthlyExpenseLabel.setText(this.MONTHLY_EXPENSE_LABEL + " ");
    }

    @FXML
    private void categorySelected(MouseEvent event) throws IOException, InterruptedException {
        try {
            commController.getCategoryPaneController().showProductsForCategory(this.category);
        } catch (IOException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void categoryHovered(MouseEvent mouseEvent) {
        categoryContainer.getStyleClass().add("category-hover");
    }

    public void catergoyNotHovered(MouseEvent mouseEvent) {
        if( categoryContainer.getStyleClass().contains("category-hover")){
            categoryContainer.getStyleClass().remove("category-hover");
        }
    }

    private void animateCategory(){
        int i=0;
        while(i<100){
            String style = String.format("-fx-background-color: linear-gradient(to right, #2D819D %d%%, #969696 %d%%);", i, i);
            categoryContainer.setStyle(style);
            i++;
        }
        return;
    }
}
