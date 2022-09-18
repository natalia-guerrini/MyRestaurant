package business;

import model.dao.ProductTable;
import model.entity.Entity;
import model.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductManager {
    private ProductTable productTable;

    public ProductManager(){
        this.productTable = new ProductTable();
    }

    public boolean updateProduct(HashMap<String, Object> productInfo){
        Product prod = this.productTable.constructEntityFromMap(productInfo);
        return this.productTable.update(prod);
    }

    public HashMap<String, Object> getProduct(int productId){
        HashMap<String, Object> res = null;
        ArrayList<Product> products = this.productTable.getFrom(productId, "barcode");
        if(!products.isEmpty()){
            Product prod = products.get(0);
            res = prod.map();
        }
        return res;
    }

    public ArrayList<HashMap<String, Object>> getFrom(Object searchParam, String paramName){
        ArrayList<Product> products = this.productTable.getFrom(searchParam, paramName);
        ArrayList<HashMap<String,Object>> res  = new ArrayList<HashMap<String,Object>>();
        for(Product product : products){
            res.add(product.map());
        }
        return res;
    }

    public boolean saveProduct(HashMap<String, Object> data){
        Product prod = this.productTable.constructEntityFromMap(data);
        return this.productTable.save(prod);
    }

    public ArrayList getAll(){
        ArrayList<Product> products = this.productTable.getAll();
        ArrayList<HashMap<String,Object>> res  = new ArrayList<HashMap<String,Object>>();
        for(Product product : products){
            res.add(product.map());
        }
        return res;
    }

    public HashMap<Integer, Integer> getStoreStatistics(int prodId){
        return this.productTable.getProductUsageInLastYear(prodId);
    }
}
