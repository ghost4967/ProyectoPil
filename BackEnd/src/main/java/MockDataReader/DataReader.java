package MockDataReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataReader {

    private List<Product> products = new ArrayList();

    public List<Product> readJson() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new FileReader("C:\\Users\\wanda\\Downloads\\RestProject\\src\\main\\resources\\MOCK_DATA.json"));


            Product product = new Product();
            for (Object object : data) {
                JSONObject productJson = (JSONObject) object;

                product.setId((String) productJson.get("id"));
                product.setName((String) productJson.get("product_name"));
                product.setStock((int) productJson.get("stock"));
                product.setProductImage((String) productJson.get("product_image"));
                products.add(product);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return products;
    }
}
