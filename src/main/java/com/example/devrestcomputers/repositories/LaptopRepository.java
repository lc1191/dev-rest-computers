package com.example.devrestcomputers.repositories;

import com.example.devrestcomputers.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
