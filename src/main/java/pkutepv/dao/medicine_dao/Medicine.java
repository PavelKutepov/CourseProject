package pkutepv.dao.medicine_dao;

public class Medicine {

    private int medicine_id;
    private String name;
    private String firm;
    private String type;
    private int price;
    private boolean recipe;


    public Medicine(int medicine_id, String name, String firm, String type, int price, boolean recipe) {
        this.medicine_id = medicine_id;
        this.name = name;
        this.firm = firm;
        this.type = type;
        this.price = price;
        this.recipe = recipe;

    }

    public Medicine(String name, String firm, String type, int price, boolean recipe) {
        this.name = name;
        this.firm = firm;
        this.type = type;
        this.price = price;
        this.recipe = recipe;

    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRecipe() {
        return recipe;
    }

    public void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }

}
