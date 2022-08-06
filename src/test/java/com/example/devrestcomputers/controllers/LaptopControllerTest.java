package com.example.devrestcomputers.controllers;

import com.example.devrestcomputers.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/v1/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

//    Posible error al no inicializar la BD
//    @Test
//    void findByOneId() {
//        ResponseEntity<Laptop> response =
//                testRestTemplate.getForEntity("/api/v1/laptops/1", Laptop.class);
//
//        // Error NOT_FOUND & 404 en caso de no inicializar la aplicacion
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(200, response.getStatusCodeValue());
//    }

    @Test
    void create() {
        // Cabeceras
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json = """
                {
                        "brand": "Laptop Test",
                        "model": "Junit test",
                        "fabYear": 2022,
                        "screen": 27,
                        "screenTactil": true,
                        "cpuThread": 24,
                        "ramGB": 64,
                        "ssdGB": 2.5,
                        "gpuGB": 12
                }                
                """;
        HttpEntity<String> request = new HttpEntity<>(json, header);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/v1/laptops", HttpMethod.POST, request, Laptop.class);
                        Laptop result = response.getBody();
        assertEquals(1L, result.getId());
        assertEquals("Laptop Test", result.getBrand());

    }
}