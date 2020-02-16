package inv.test.pruebaspring.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(generator = "category_sequence")
    @Column
    private int id;

    @NotNull
    @Column
    private String name;

    @Lob
    @Column
    private byte[] photo;

    @OneToOne
    private Category parentCategory;

    public Category(String name, byte[] photo) {
        this.name = name;
        this.photo = photo;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(byte[] photo) {
        this.photo = photo;
    }

    public Category() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Category getParentCategory() {
        return this.parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
}
