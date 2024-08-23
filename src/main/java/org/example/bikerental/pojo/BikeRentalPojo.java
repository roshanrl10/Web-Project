package org.example.bikerental.pojo;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BikeRentalPojo {
    private Integer id;
    private String bikeBrand; // Updated from carBrand to bikeBrand
    private Integer seat;
    private Integer price;
    private MultipartFile bikeImage; // Updated from carImage to bikeImage
}
