package org.example.bikerental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "bike_booking")
@Getter
@Setter
public class BikeBookingEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bike_seq_gen")
    @SequenceGenerator(name = "bike_seq_gen", sequenceName = "bike_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "rental_start_date_time")
    private LocalDateTime rentalStartDateTime;

    @Column(name = "rental_end_date_time")
    private LocalDateTime rentalEndDateTime;

    @Column(name = "total_amount")
    private Double totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "Bike_Id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "foreign_key_bike_details_id"))
    private BikeRentalEntity bike;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "foreign_key_user_details_id"))
    private RegistrationEntity registration;
}
