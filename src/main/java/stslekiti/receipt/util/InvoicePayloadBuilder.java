package stslekiti.receipt.util;

import stslekiti.receipt.entity.LandLord;
import stslekiti.receipt.payload.response.InvoiceResponse;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class InvoicePayloadBuilder {

    public static List<InvoiceResponse> multipleLandOwnersInvoiceBuilder(List<LandLord> landOwners) {

        List<InvoiceResponse> invoices = new ArrayList<>();

//        for (LandLord landOwner : landOwners) {
//            landOwner.getProperties().forEach();
//        }
        invoices.addAll(landOwners.stream()
                .map(InvoicePayloadBuilder::singleLandOwnerInvoiceBuilder)
                .flatMap(Collection::stream).toList());

        return invoices;
    }

    public static List<InvoiceResponse> singleLandOwnerInvoiceBuilder(LandLord landOwner) {
        List<InvoiceResponse> invoices = new ArrayList<>();

        landOwner.getProperties().forEach(property -> {
            InvoiceResponse invoice = InvoiceResponse.builder().payerName(landOwner.getLastName() + landOwner.getFirstName())
                    .payerId(landOwner.getId().toString()).contactAddress(landOwner.getAddress())
                    .noticeNumber(new BigInteger(landOwner.getPhone())).LGA(property.getLGA())
                    .propertyAddress(property.getAddress()).propertyClassification(property.getStructure())
                    .status(property.getPropertyUse()).bankPaymentCode(new BigInteger("1010101"))
                    .accessedValue(new BigInteger("1100100")).amountPreviouslyOwed(new BigInteger("10"))
                    .lucAmount(new BigInteger("100")).chargeRate(5.0).noticeDate(LocalDate.now())
                    .printDate(LocalDate.now()).build();
            invoices.add(invoice);
        });

        return invoices;
    }

}
