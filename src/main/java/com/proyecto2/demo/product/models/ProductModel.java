package com.proyecto2.demo.product.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class ProductModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Id @Column(name = "id")
    private long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @DecimalMin(value = "0.01")
    @Getter @Setter @Column(name = "price")
    private BigDecimal price;

    @Getter @Setter @Column(name = "date_expiration")
    private LocalDateTime fechaCaducacion;
}
