package in.purabtech.mongodb.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Product {

    private String name;
    private int quantity;
    private int price;

}
