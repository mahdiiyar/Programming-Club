package club.business;

import java.io.Serializable;

public class Book implements Serializable {

    private String code;
    private String description;
    private int quantity;

    public Book() {
        code = "";
        description = "";
        quantity = 0;
    }

    public Book(String code, String description, int quantity) {
        this.code = code;
        this.description = description;
        this.quantity = quantity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}