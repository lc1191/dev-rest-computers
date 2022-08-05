package com.example.devrestcomputers.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "Laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Integer fabYear;
    private Double screen;
    private Boolean screenTactil;
    @ApiModelProperty("Numero de nucleos")
    private Integer cpuThread;
    @ApiModelProperty("Tamaño de memoria ram (GB)")
    private Integer ramGB;
    @ApiModelProperty("Tamaño de ssd (GB)")
    private Double ssdGB;
    @ApiModelProperty("Tamaño de grafica (GB)")
    private Integer gpuGB;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, Integer fabYear, Double screen, Boolean screenTactil, Integer cpuThread, Integer ramGB, Double ssdGB, Integer gpuGB) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.fabYear = fabYear;
        this.screen = screen;
        this.screenTactil = screenTactil;
        this.cpuThread = cpuThread;
        this.ramGB = ramGB;
        this.ssdGB = ssdGB;
        this.gpuGB = gpuGB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getFabYear() {
        return fabYear;
    }

    public void setFabYear(Integer fabYear) {
        this.fabYear = fabYear;
    }

    public Double getScreen() {
        return screen;
    }

    public void setScreen(Double screen) {
        this.screen = screen;
    }

    public Boolean getScreenTactil() {
        return screenTactil;
    }

    public void setScreenTactil(Boolean screenTactil) {
        this.screenTactil = screenTactil;
    }

    public Integer getCpuThread() {
        return cpuThread;
    }

    public void setCpuThread(Integer cpuThread) {
        this.cpuThread = cpuThread;
    }

    public Integer getRamGB() {
        return ramGB;
    }

    public void setRamGB(Integer ramGB) {
        this.ramGB = ramGB;
    }

    public Double getSsdGB() {
        return ssdGB;
    }

    public void setSsdGB(Double ssdGB) {
        this.ssdGB = ssdGB;
    }

    public Integer getGpuGB() {
        return gpuGB;
    }

    public void setGpuGB(Integer gpuGB) {
        this.gpuGB = gpuGB;
    }
}

