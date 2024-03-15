package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
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
    @Column(name = "company_id", unique = true)
    private UUID companyId;

    @Column(name="name", unique = true)
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hardware> hardwares;

}
