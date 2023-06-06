package org.example;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appdate;
    @OneToOne
    @JoinColumn(name = "patient")
    private Patient patient;
    private Payment payment;
    @OneToOne
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    public Appointment(String appdate, Patient patient, Payment payment, Doctor doctor) {
        this.appdate = appdate;
        this.patient = patient;
        this.payment = payment;
        this.doctor = doctor;
    }
}
