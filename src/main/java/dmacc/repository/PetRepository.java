package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
