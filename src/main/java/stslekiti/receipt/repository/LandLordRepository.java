package stslekiti.receipt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stslekiti.receipt.entity.LandLord;

import java.util.List;

public interface LandLordRepository extends JpaRepository<LandLord, Long> {

    List<LandLord> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}
