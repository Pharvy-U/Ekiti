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
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("1 Omobajesu Close")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("1-PS").payerName("John Doe").propertyAddress("1 Oniru Estate, Victoria Island").propertyClassification("Commercial")
				.LGA("Akowonjo").status("Paid").build();
		receiptRepository.save(person1);

		Receipt person2 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("3 Fadeyi Estate")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("3-PS").payerName("Francis Demilare").propertyAddress("1 Oniru Estate, Victoria Island").propertyClassification("Commercial")
				.LGA("Ikeja").status("Paid").build();
		receiptRepository.save(person2);

		Receipt person3 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("3 Oniru Estate")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("2-PS").payerName("Tony Stark").propertyAddress("1 Oniru Estate, Victoria Island").propertyClassification("Commercial")
				.LGA("Alimosho").status("Pending").build();
		receiptRepository.save(person3);

		Receipt person4 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("20, Adefarasi Street")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("1-PS").payerName("Bisola Afolabi").propertyAddress("1 Oniru Estate, Victoria Island").propertyClassification("Commercial")
				.LGA("Lekki").status("Paid").build();
		receiptRepository.save(person4);

		Receipt person5 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("5, Adeniyi Jones")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("5-PS").payerName("Daniel Opara").propertyAddress("1 Oniru Estate, Victoria Island").propertyClassification("Commercial")
				.LGA("Shongunle").status("Pending").build();
		receiptRepository.save(person5);

		Receipt person6 = Receipt.builder().accessedValue(BigInteger.valueOf(12340000)).amountPreviouslyOwed(BigInteger.valueOf(750))
				.bankPaymentCode(BigInteger.valueOf(123456789)).chargeRate(0.0394).contactAddress("3, Ogun Street")
				.lucAmount(BigInteger.valueOf(5735)).noticeNumber(BigInteger.valueOf(1212121212)).noticeDate(LocalDate.now()).printDate(LocalDate.now())
				.payerId("4-PS").payerName("Peter Ewuzie").propertyAddress("1 Oniru Estate, Victoria Island").propertyClassification("Commercial")
				.LGA("Ikeja").status("Paid").build();
		receiptRepository.save(person6);

	}
}
