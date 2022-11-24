package Controller;

import MockDataReader.DataReader;
import Model.Product;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/JSON", produces="application/json")
public class StockController {

    @GetMapping("/data")
    public List<Product> get() {
        DataReader mockData = new DataReader();
        List<Product> products = mockData.readJson();

        return products;
    }

    @GetMapping("/{id}/{name}/{data}")
    public ResponseEntity<Product> getData(@PathVariable("id") String id,
                                           @PathVariable("name") String name,
                                           @PathVariable("stock") int stock,
                                           @PathVariable("product_image") String productImage) {

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setStock(stock);
        product.setProductImage(productImage);

        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Product> entity = new ResponseEntity<>(product,headers,HttpStatus.CREATED);

        return entity;
    }
}

