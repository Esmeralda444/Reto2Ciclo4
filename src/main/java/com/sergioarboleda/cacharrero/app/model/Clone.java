package com.sergioarboleda.cacharrero.app.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


/**
 * @author esmeralda
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clone")
public class Clone {

    @Id
    private Integer id;
    @NotNull
    @NotBlank
    private String brand;
    @NotNull
    @NotBlank
    private String procesor;
    @NotNull
    @NotBlank
    private String os;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    private String memory;
    @NotNull
    @NotBlank
    private String hardDrive;
    @NotNull
    private boolean availability = true;
    @NotNull
    private double price;
    @NotNull
    private int quantity;
    @NotNull
    @NotBlank
    private String photography;

}
