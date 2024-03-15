package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "companies")
@ToString
@NoArgsConstructor
public class Company implements Serializable {

    @Id
    private UUID companyId;

    @Column(name="name", unique = true)
    String name;

    @Column(name = "nip")
    double NIP;

}
