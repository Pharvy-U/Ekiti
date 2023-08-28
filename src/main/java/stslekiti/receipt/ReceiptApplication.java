package stslekiti.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import stslekiti.receipt.entity.Receipt;
import stslekiti.receipt.repository.ReceiptRepository;

import java.math.BigInteger;
import java.time.LocalDate;

@SpringBootApplication
public class ReceiptApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReceiptApplication.class, args);
	}

	@Autowired
	ReceiptRepository receiptRepository;

	@Override
	public void run(String... args) throws Exception {

		Receipt person1 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("1 Omobajesu Close, Akowonjo, Lagos State")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("1-PS").payerName("John Doe").propertyAddress("1 Oniru Estate, Victoria Island, Lagos State").propertyClassification("Occupied").build();
		receiptRepository.save(person1);

		Receipt person2 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("1 Omobajesu Close, Akowonjo, Lagos State")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("1-PS").payerName("Francis Demilare").propertyAddress("1 Oniru Estate, Victoria Island, Lagos State").propertyClassification("Occupied").build();
		receiptRepository.save(person2);

		Receipt person3 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("1 Omobajesu Close, Akowonjo, Lagos State")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("1-PS").payerName("Tony Stark").propertyAddress("1 Oniru Estate, Victoria Island, Lagos State").propertyClassification("Occupied").build();
		receiptRepository.save(person3);

		Receipt person4 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("1 Omobajesu Close, Akowonjo, Lagos State")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("1-PS").payerName("Bisola Afolabi").propertyAddress("1 Oniru Estate, Victoria Island, Lagos State").propertyClassification("Occupied").build();
		receiptRepository.save(person4);

	}
}
