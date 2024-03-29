package view.sceneControllers;

import business.OrderManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;

public class OrderController extends BaseView{

    public static String numberLabelId = "#numberLabel";

    public Label supplierLabel;
    public Label numberLabel;
    public Label dateLabel;
    public AnchorPane deliveredBtn;
    private HashMap<String, Object> info;

    public void setOrderInfo(HashMap<String, Object> info){
        this.info = info;
        numberLabel.setText(info.get("number").toString());
        dateLabel.setText(info.get("date").toString());
        supplierLabel.setText(info.get("supplier").toString());
    }

    public void hideDeliveredBtn(){
        this.deliveredBtn.setVisible(false);
        this.deliveredBtn.setManaged(false);
    }
    public void setDelivered(MouseEvent mouseEvent) {
        OrderPaneController opc = commController.getOrderPaneController();
        opc.setDelivered(info);
    }
}

