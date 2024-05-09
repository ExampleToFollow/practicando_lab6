package com.example.practicando_lab6.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;


@Entity
@Table(name ="technician")
public class Technician {
    @Id
    @Column(name="TechnicianID")
    private int technicianId;
    @Column(name="firstname")
    @Size(min=3 , max= 100 , message="El nombre debe de tener por lo menos 3 caracteres y máximo 100")
    @NotBlank(message = "Este campo no debe estar vacío")
    private String firstName;
    @Size(min=3 , max= 100 , message="El apellido debe de tener por lo menos 3 caracteres y máximo 100")
    @Column(name="lastname")
    @NotBlank(message = "Este campo no debe estar vacío")
    private String lastName;
    @Size(min=8,max=8 , message = "el campo debe ser un número entero de OCHO digitos")
    @Column(name="Dni")
    @Pattern(regexp = "^\\d+$", message = "El campo debe ser un número entero")
    @NotBlank(message = "Este campo no debe estar vacío")
    private String dni;
    @Column(name="Phone")
    @Size(min=9,max=9 , message = "el campo debe ser un número entero de NUEVE digitos")
    @Pattern(regexp = "^\\d+$", message = "El campo debe ser un número entero")
    @NotBlank(message = "Este campo no debe estar vacío")
    private String phoneNumber;
    //Validar edad
    @Column(name="Age")
    @Positive(message="debe ser un número positivo")
    @NotNull(message = "not null")
    private int age;

    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
