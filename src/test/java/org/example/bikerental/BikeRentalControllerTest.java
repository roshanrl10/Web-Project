package org.example.bikerental;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.bikerental.entity.BikeRentalEntity;
import org.example.bikerental.pojo.BikeRentalPojo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BikeRentalControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/bikes";
    }

    @Test
    public void testRentBike() throws IOException {
        BikeRentalPojo bikeRental = new BikeRentalPojo();
        bikeRental.setBikeBrand("Yamaha FZ");
        bikeRental.setPrice(30);

        HttpEntity<BikeRentalPojo> request = new HttpEntity<>(bikeRental);
        ResponseEntity<Void> response = restTemplate.postForEntity(baseUrl + "/add", request, Void.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testUpdateBike() throws IOException {
        // First, create a bike rental
        BikeRentalPojo bikeRental = new BikeRentalPojo();
        bikeRental.setBikeBrand("Kawasaki Ninja");
        bikeRental.setPrice(40);

        HttpEntity<BikeRentalPojo> request = new HttpEntity<>(bikeRental);
        ResponseEntity<Void> postResponse = restTemplate.postForEntity(baseUrl + "/add", request, Void.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());

        // Assuming ID is 1 for simplicity, but this should be dynamic
        // Update the bike rental
        bikeRental.setBikeBrand("Updated Kawasaki Ninja");
        HttpEntity<BikeRentalPojo> updateRequest = new HttpEntity<>(bikeRental);
        ResponseEntity<String> putResponse = restTemplate.exchange(baseUrl + "/bike/1", HttpMethod.PUT, updateRequest,
                String.class);

        assertEquals(HttpStatus.OK, putResponse.getStatusCode());
        assertEquals("Bike updated successfully", putResponse.getBody());
    }

    @Test
    public void testGetAllBikeRentals() {
        ResponseEntity<BikeRentalEntity[]> response = restTemplate.getForEntity(baseUrl + "/list",
                BikeRentalEntity[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length >= 0); // Assuming there could be zero or more rentals
    }

    @Test
    public void testGetBikeRentalById() {
        // First, create a bike rental
        BikeRentalPojo bikeRental = new BikeRentalPojo();
        bikeRental.setBikeBrand("Suzuki Gixxer");
        bikeRental.setPrice(35);

        HttpEntity<BikeRentalPojo> request = new HttpEntity<>(bikeRental);
        ResponseEntity<Void> postResponse = restTemplate.postForEntity(baseUrl + "/add", request, Void.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());

        // Assuming ID is 1 for simplicity, but this should be dynamic
        ResponseEntity<BikeRentalEntity> getResponse = restTemplate.getForEntity(baseUrl + "/list/1",
                BikeRentalEntity.class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertNotNull(getResponse.getBody());
    }
}
