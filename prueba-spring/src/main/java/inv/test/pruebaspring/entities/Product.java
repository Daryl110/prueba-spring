package inv.test.pruebaspring.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(generator = "product_sequence")
    @Column
    private int id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String description;

    @NotNull
    @Column
    private Double weight;

    @NotNull
    @Column
    private Double price;

    @Lob
    @Column(name = "photo_1")
    private byte[] photo1;

    @Lob
    @Column(name = "photo_2")
    private byte[] photo2;

    @Lob
    @Column(name = "photo_3")
    private byte[] photo3;

    @NotNull
    @ManyToOne
    private Category category;

    public Product(String name, String description, Double weight, Double price, byte[] photo1, byte[] photo2,
                   byte[] photo3, Category category) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.category = category;
    }

    public Product(String name, String description, Double weight, Double price, Category category) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getPhoto1() {
        return photo1;
    }

    public void setPhoto1(byte[] photo1) {
        this.photo1 = photo1;
    }

    public byte[] getPhoto2() {
        return photo2;
    }

    public void setPhoto2(byte[] photo2) {
        this.photo2 = photo2;
    }

    public byte[] getPhoto3() {
        return photo3;
    }

    public void setPhoto3(byte[] photo3) {
        this.photo3 = photo3;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
