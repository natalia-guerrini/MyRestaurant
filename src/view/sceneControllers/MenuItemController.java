/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.sceneControllers;

import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.HashMap;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import view.utils.imageManagers.LocatedImage;

public class MenuItemController extends BaseView implements Initializable {
    public AnchorPane dishAnchorPane;
    public ImageView imgDish;
    public Label itemNameLbl;
    public Label itemPriceLbl;
    
    private HashMap<String, Object> dishInfo;
    
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
    }
    
    public void setDishInfo( HashMap<String, Object> dishInfo, HashMap<String, Object> course) {
        this.dishInfo = dishInfo;
        String name = course.get("name").toString();
        this.itemNameLbl.setText((String)dishInfo.get("nameDish"));
        this.itemPriceLbl.setText("€" + dishInfo.get("price").toString());
        if (course.get("img") != null){
            this.imgDish.setImage(imagesProvider.getCourseIcon(name));
        }
    }
    
    public HashMap<String, Object> getDishInfo() {
        return dishInfo;
    }
    
    @FXML
    public void itemSelected( MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource(this.DISHINFO_PANE_PATH));
         Node dishInfoPane = loader.load();
         commController.getDashboardController().setRightPane(dishInfoPane);
         DishInfoController dishInfoContr = loader.getController();
         dishInfoContr.setChosenDish(this.dishInfo);
    }
    
    public void itemHovered(MouseEvent mouseEvent) {
        this.dishAnchorPane.getStyleClass().add("product-hover");
    }
    
    public void itemNotHovered( MouseEvent mouseEvent) {
        if (this.dishAnchorPane.getStyleClass().contains("product-hover")) {
            this.dishAnchorPane.getStyleClass().remove("product-hover");
        }
    }

}
