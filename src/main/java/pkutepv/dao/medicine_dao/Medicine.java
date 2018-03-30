package pkutepv.dao.medicine_dao;

import pkutepv.entity.Model;

import javax.persistence.Column;
import javax.persistence.Entity;


public class Medicine extends Model {

    public final String name;

    private final String firm;

    private final String type;

    private int price;

    private boolean recipe;

    public Medicine(Long id, String name, String firm, String type, int price, boolean recipe) {
        super(id);
        this.name = name;
        this.firm = firm;
        this.type = type;
        this.price = price;
        this.recipe = recipe;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public String getFirm() {
        return firm;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public boolean isRecipe() {
        return recipe;
    }
}
