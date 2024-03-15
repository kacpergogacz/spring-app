package org.example.repositories;


import org.example.entities.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HardwareRepository extends JpaRepository<Hardware, UUID> {

    Optional<Hardware> findByName(String Name);

    @Override
    List<Hardware> findAll();




}