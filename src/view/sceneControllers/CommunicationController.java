package view.sceneControllers;

import javafx.stage.Stage;
import java.util.HashMap;

/**
 *
 * @author milar
 */
public final class CommunicationController {
    
    private static final CommunicationController commController = new CommunicationController();

    private Stage stage = null;
    private ProductsPaneController productsPaneController = null;
    private CategoryPaneController categoryPaneController = null;
    private MenuPaneController menuPaneController = null;
    private MenuListController menuListController = null;
    private EmployeesListController employeesListController = null;
    private UtilitiesPaneController utilitiesPaneController = null;
    private UtilityItemController utilityitemController = null;
    private AddUtilityController addUtilityPaneController = null;
    private DashboardController dashboardController = null;
    private DishInfoController dishinfoController = null;
    private OrderPaneController orderPaneController = null;
    private OrderSearchController orderSearchController = null;
    private MenuItemController menuitemController = null;
    private EmployeeInfoPaneController employeeinfoController = null;
    private ProductInfoPaneController productInfoPaneController = null;
    private AddOrderPaneController addOrderPaneController = null;
    private LoginPaneController loginPaneController = null;
    private UserAdministrationPaneController userAdministrationPaneController = null;
    private HashMap<String, Object> loggedUser = null;
    
    private CommunicationController() {}

    public static CommunicationController getInstance(){
        return commController;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
    public Stage getStage() {
        return stage;
    }

    public void setCategoryPaneController(CategoryPaneController catController){
        if(this.categoryPaneController == null){
            this.categoryPaneController = catController;
        }
    }
    public CategoryPaneController getCategoryPaneController(){
        return this.categoryPaneController;
    }
    
    public void setProductPaneController(ProductsPaneController productsPaneController){
        if(this.productsPaneController == null){
            this.productsPaneController = productsPaneController;
        }
    }
    public ProductsPaneController getProductsPaneController(){
        return this.productsPaneController;
    }
    
    public void setUtilitiesPaneController(UtilitiesPaneController utilitiesPaneController){
        if(this.utilitiesPaneController == null){
            this.utilitiesPaneController = utilitiesPaneController;
        }
    }
    public UtilitiesPaneController getUtilitiesPaneController(){
        return this.utilitiesPaneController;
    }
    
    public void setUtilityItemController(UtilityItemController utilityitemController){
        if(this.utilityitemController == null){
            this.utilityitemController = utilityitemController;
        }
    }
    public UtilityItemController getUtilityItemController(){
        return this.utilityitemController;
    }
    

    public void setMenuPaneController(MenuPaneController menuPaneController){
        if(this.menuPaneController == null){
            this.menuPaneController = menuPaneController;
        }
    }
    public MenuPaneController getMenuPaneController(){
        return this.menuPaneController;
    }
    
    public void setMenuListController(MenuListController menuListController){
        if(this.menuListController == null){
            this.menuListController = menuListController;
        }
    }
    public MenuListController getMenuListController(){
        return this.menuListController;
    }
    
    public void setEmployeePaneController(EmployeesListController employeesListController){
        if(this.employeesListController == null){
            this.employeesListController = employeesListController;
        }
    }
    public EmployeesListController getEmployeePaneController(){
        return this.employeesListController;
    }

    public void setDashboardController(DashboardController dc){
        if(this.dashboardController == null){
            this.dashboardController = dc;
        }
    }
    public DashboardController getDashboardController(){ 
        return this.dashboardController;
    }
    
    public void setDishInfoController(DishInfoController dishinfoController){
        if(this.dishinfoController == null){
            this.dishinfoController = dishinfoController;
        }
    }
    public DishInfoController getDishInfoController(){
        return this.dishinfoController;
    }
    public void setEmployeeInfoController(EmployeeInfoPaneController employeeinfoController){
        if(this.employeeinfoController == null){
            this.employeeinfoController = employeeinfoController;
        }
    }
    public EmployeeInfoPaneController getEmployeeInfoController(){
        return this.employeeinfoController;
    }

    public void setOrderPaneController(OrderPaneController op){
        if(this.orderPaneController == null){
            this.orderPaneController = op;
        }
    }
    public OrderPaneController getOrderPaneController(){return this.orderPaneController; }

    public void setOrderSearchController(OrderSearchController osc){
        if(this.orderSearchController == null){
             this.orderSearchController = osc;
        }
    }
    public OrderSearchController getOrderSearchController(){return this.orderSearchController;}

    
    public void setMenuItemController(MenuItemController menuitemController){
        if(this.menuitemController == null){
            this.menuitemController = menuitemController;
        }
    }
    public MenuItemController getMenuItemController(){
        return this.menuitemController;
    }


    public void setProductInfoPaneController(ProductInfoPaneController productInfoPaneController) {
        if(this.productInfoPaneController == null){
            this.productInfoPaneController = productInfoPaneController;
        }
    }
    public ProductInfoPaneController getProductInfoPaneController(){return this.productInfoPaneController;}

    public void setAddOrderPaneController(AddOrderPaneController addOrderPaneController){
        if(this.addOrderPaneController == null){
            this.addOrderPaneController = addOrderPaneController;
        }
    }
    public AddOrderPaneController getAddOrderPaneController(){return this.addOrderPaneController;}

    public void setLoginPaneController(LoginPaneController lpc){
        if(this.loginPaneController == null){
            this.loginPaneController = lpc;
        }
    }
    public LoginPaneController getLoginPaneController() { return this.loginPaneController; }

    public void setUserAdministrationPaneController(UserAdministrationPaneController uapc){
        if(this.userAdministrationPaneController == null){
            this.userAdministrationPaneController = uapc;
        }
    }
    public UserAdministrationPaneController getUserAdministrationPaneController() {
        return userAdministrationPaneController;
    }

    public void setLoggedUser(HashMap<String, Object> user){
        this.loggedUser = user;
    }
    public HashMap<String, Object> getLoggedUser(){ return this.loggedUser; }
}
