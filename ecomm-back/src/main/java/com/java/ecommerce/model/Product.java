package com.java.ecommerce.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "product", schema = "app")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp//automatic manage the timestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @CreationTimestamp
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)//categ_id- a field that is defined in this category
    private Category category;


    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

}
