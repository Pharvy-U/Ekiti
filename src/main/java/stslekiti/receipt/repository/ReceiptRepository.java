package stslekiti.receipt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stslekiti.receipt.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
