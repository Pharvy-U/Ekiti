package stslekiti.receipt.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stslekiti.receipt.entity.Receipt;
import stslekiti.receipt.payload.GenericResponseDTO;
import stslekiti.receipt.service.ReceiptService;

import java.util.List;

@Controller
@RequestMapping("/api/")
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }


    @GetMapping("invoice/print/{id}")
    public String printInvoice(@PathVariable Long id, Model model) {

        Receipt receipt = receiptService.handleFetchInvoiceRequest(id);
        model.addAttribute("detail", receipt);
        return "receipt";
    }

    @GetMapping(value="invoice/fetch/{id}")
    public @ResponseBody GenericResponseDTO fetchInvoice(@PathVariable Long id) {

        Receipt receipt = receiptService.handleFetchInvoiceRequest(id);
        return new GenericResponseDTO("00", "Successfully fetched Invoice", receipt);
    }

    @GetMapping("invoice/fetch/all")
    public @ResponseBody GenericResponseDTO fetchAllInvoices(Model model) {
        return receiptService.handleFetchAllInvoicesRequest();
    }

    @PostMapping()
    public GenericResponseDTO populateDB() {
        return receiptService.handlePopulateDB();
    }
}
