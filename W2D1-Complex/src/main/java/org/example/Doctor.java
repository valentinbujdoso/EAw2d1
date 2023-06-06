package org.example;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String doctortype;
    private String firstname;
    private String lastname;

    public Doctor(String doctortype, String firstname, String lastname) {
        this.doctortype = doctortype;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
