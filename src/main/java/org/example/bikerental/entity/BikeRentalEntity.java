package org.example.bikerental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bike_rental")
@Getter
@Setter
public class BikeRentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bike_rental_seq_gen")
    @SequenceGenerator(name = "bike_rental_seq_gen", sequenceName = "bike_rental_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "bike_brand")
    private String bikeBrand;

    @Column(name = "seat")
    private Integer seat;

    @Column(name = "price")
    private Integer price;

    @Column(name = "bike_image")
    private String bikeImage;
}
