package com.example.Android;

public class Items {
    private  int id;
private String name;
private  String type;
private String description;
private String color;
private int price;
private String size;
    private String rating;
    private int imageID;



    public static final Items[] Items = {
            new Items(1,"White and BLack T-Shirt ","L,XL,XLL,XLLL","T-shirt","Men Nike T-shirt."
                          ,"black-White",30,"Rating: 4.4",R.drawable.sportshirt),
            new Items(2,"Green Shoes","37,38,39,40,41,42","Shoes","Women green shoes with white color in the bottom uses."
                    ,"green",60, "Rating: 3",R.drawable.greenshoes),
            new Items(3,"Sport Balls","Radius :80cm","Balls","Radius:80cm."
                    ,"Blue,Purple,white",20,"Rating: 4.2",R.drawable.balls),
            new Items(4,"Black Dumbbells ","","Dumbbells","25 Kilo Dumbbells."
                    ,"black",70,"Rating: 4.2",R.drawable.blackdumbbells),
            new Items(5,"Adidas Bag","","Bags","Adidas Women Purple sport bag."
                    ,"Purple",27,"Rating: 4.8",R.drawable.adidasbag),

            new Items(6,"headbands","","Headbands","Women and Men headbands."
                    ,"black,gray,white",10,"Rating: 3.5",R.drawable.headbands),

            new Items(7,"Training Gloves","","Gloves","Women and Men use to cycling and Gyms."
                    ,"colorful",14,"Rating: 3.2",R.drawable.traininggloves),

            new Items(8,"Shorts","L,XL,XLL,XLLL","Shorts","Men Shorts."
                    ,"black,Dark Blue,blue,red",30,"Rating: 4",R.drawable.shorts),

            new Items(9,"Sport Mattress","","0.5 Inch","BalanceFrom GoYoga All-Purpose 1/2-Inch Extra Thick High Density Anti-Tear Exercise Yoga Mat with Carrying Strap."
                    ,"blue",21,"Rating: 4.7",R.drawable.sportmattress),



    };
    public static Items findItemsByid(int id){
        for (int i = 0;i<Items.length;i++){
            if(Items[i].getId() == id){
                return Items[i];
            }
        }
        return null;

    }


    public Items(int id, String name, String size, String type, String description, String color, int price, String rating, int imageID) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.description = description;
        this.color = color;
        this.price = price;
        this.rating = rating;
        this.imageID = imageID;

    }

    public Items(int id, String name, String color, int price, int imageID,String size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.imageID = imageID;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public static com.example.Android.Items[] getItems() {
        return Items;
    }
    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", rating='" + rating + '\'' +
                ", imageID=" + imageID +
                '}';
    }
}

