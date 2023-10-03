package stslekiti.receipt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stslekiti.receipt.entity.Receipt;
import stslekiti.receipt.payload.request.AddPropertyRequest;
import stslekiti.receipt.payload.response.GenericResponseDTO;
import stslekiti.receipt.service.ReceiptService;

@Controller
@RequestMapping("/api/")
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }


    @CrossOrigin
    @GetMapping("invoice/print/{id}")
    public String printInvoice(@PathVariable Long id, Model model) {

        Receipt receipt = receiptService.handleFetchInvoiceRequest(id);
        model.addAttribute("detail", receipt);
        return "receipt";
    }

    @CrossOrigin
    @GetMapping(value="invoice/fetch/pp/{id}")
    public @ResponseBody GenericResponseDTO fetchInvoice(@PathVariable Long id) {

        Receipt receipt = receiptService.handleFetchInvoiceRequest(id);
        return new GenericResponseDTO("00", "Successfully fetched Invoice", receipt);
    }

    @CrossOrigin
    @GetMapping("invoice/fetch/pp/all")
    public @ResponseBody GenericResponseDTO fetchAllInvoices(Model model) {
        return receiptService.handleFetchAllInvoicesRequest();
    }

//    @PostMapping()
//    public @ResponseBody GenericResponseDTO addProperty(@RequestBody AddPropertyRequest addPropertyRequest) {
//        return receiptService.handleAddProperty(addPropertyRequest);
//    }
}
