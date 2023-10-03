package stslekiti.receipt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stslekiti.receipt.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
