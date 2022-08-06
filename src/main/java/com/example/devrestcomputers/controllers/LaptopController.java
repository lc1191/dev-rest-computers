package com.example.devrestcomputers.controllers;

import com.example.devrestcomputers.entities.Laptop;
import com.example.devrestcomputers.repositories.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // Registro Log
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // Repositorio
    private LaptopRepository laptoprepository;

    // Constructor repositorio
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptoprepository = laptopRepository;
    }

    /**
     * Mensaje desde application properties
     */
    @Value("${app.message}")
    String message;

    /**
     * holaMundo()
     * Imprimir mensaje Hola Mundo!
     * @return String
     */
    @GetMapping("/hola")
    public String holaMundo() {
        System.out.println(message);
        return "Hola Mundo!";
    }

    /**
     * findAll()
     * Devuelve lista de objetos Laptop
     * @return laptoprepository
     */
    @GetMapping("/api/v1/laptops")
    @ApiOperation("Buscar todos los portatiles")
    public List<Laptop> findAll() {
        log.info("success to find a laptops on database");
        return laptoprepository.findAll();
    }

    /**
     * findByOneId()
     * Devuelve un laptop segun id introducido
     * @param id
     */
    @GetMapping("api/v1/laptops/{id}")
    @ApiOperation("Buscar un portatil segun id")
    public ResponseEntity<Laptop> findByOneId(@PathVariable Long id) {
        Optional<Laptop> lapOpt = laptoprepository.findById(id);
        if(lapOpt.isPresent()){
            log.info("success to find a laptop with id " + id);
            return ResponseEntity.ok(lapOpt.get());
        } else {
            log.warn("trying to find a laptop with id " + id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * create()
     * Crea datos en la base de datos
     * @param laptop
     * @return laptoprespository
     */
    @PostMapping("/api/v1/laptops")
    @ApiOperation("Crear portatiles")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if (laptop.getId() != null) {
            log.warn("trying to create a laptop with id " + laptop.getId());
            return ResponseEntity.badRequest().build();
        }
        log.info("success to create a laptop");
        Laptop result = laptoprepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    /**
     * update()
     * Actualiza registro en base de datos segun id
     * @param laptop
     * @return laptoprepository
     */
    @PutMapping("api/v1/laptops/{id}")
    @ApiOperation("Actualiza un portatil segun id")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if(laptop.getId() == null){
            log.warn("trying to update a laptop with id " + laptop.getId());
            return ResponseEntity.badRequest().build();
        }
        if (!laptoprepository.existsById(laptop.getId())){
            log.warn("trying to update a laptop with id " + laptop.getId());
            return ResponseEntity.notFound().build();
        }
        log.info("success to update a laptop");
        Laptop result = laptoprepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    /**
     * delete()
     * Elimina un registro de la base de datos segun el id introducido
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("api/v1/laptops/{id}")
    @ApiOperation("Elimina un portatil segun id")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if (!laptoprepository.existsById(id)){
            log.warn("trying to delete a laptop with id " + id);
            return ResponseEntity.notFound().build();
        }
        log.info("success to delete a laptop with id " + id);
        laptoprepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * deleteAll()
     * Elimina todos los registros de la base de datos
     * @return ResponseEntity
     */
    @DeleteMapping("api/v1/laptops")
    @ApiOperation("Elimina todos los portatiles")
    public ResponseEntity<Laptop> deleteAll() {
        log.info("success to delete all laptops");
        laptoprepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
