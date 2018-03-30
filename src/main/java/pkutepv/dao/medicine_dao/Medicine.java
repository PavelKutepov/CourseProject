package pkutepv.dao.medicine_dao;

import pkutepv.entity.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Medicine extends Model {
    @Column(name = "name")
    public String name;
    @Column(name = "firm")
    private String firm;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private int price;
    @Column(name = "recipe")
    private boolean recipe;

    public Medicine(Long id, String name, String firm, String type, int price, boolean recipe) {
        super(id);
        this.name = name;
        this.firm = firm;
        this.type = type;
        this.price = price;
        this.recipe = recipe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setType(String type) {
        this.type = type;
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
