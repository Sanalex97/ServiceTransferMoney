package moneytransferservice.controller;

import jakarta.validation.Valid;
import moneytransferservice.model.InfoTransfer;
import moneytransferservice.model.Operation;
import moneytransferservice.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MoneyTransferServiceController {

    TransferService transferService;
    InfoTransfer transfer;

    public MoneyTransferServiceController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> sendMoney(@Valid @RequestBody InfoTransfer infoTransfer) {
        transfer = infoTransfer;
        return transferService.logMoneyTransfer(infoTransfer);
    }

    @PostMapping("/confirmOperation")
    public void confirmOperation(@RequestBody Operation operation) {
        transfer.setOperation(operation);
    }

}
