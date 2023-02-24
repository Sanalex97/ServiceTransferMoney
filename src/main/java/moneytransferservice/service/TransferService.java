package moneytransferservice.service;

import moneytransferservice.log.Logger;
import moneytransferservice.model.InfoTransfer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    private static final Logger logger = Logger.getInstance();

    public ResponseEntity<String> logMoneyTransfer(InfoTransfer infoTransfer) {
        if (infoTransfer.getCardFromNumber().equals(infoTransfer.getCardToNumber())) {
            infoTransfer.setResultOperation("error transfer");
            logger.log(infoTransfer);
            HttpHeaders headers = new HttpHeaders();
            headers.add("description", "error transfer");
            return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } else if (infoTransfer.getAmount().getValue() < 10) {
            infoTransfer.setResultOperation("error input data");
            logger.log(infoTransfer);
            HttpHeaders headers = new HttpHeaders();
            headers.add("description", "error input data");
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        } else {
            infoTransfer.setResultOperation("OK");
            logger.log(infoTransfer);
            HttpHeaders headers = new HttpHeaders();
            headers.add("description", "Success transfer");
            headers.add("operationId", infoTransfer.getIdOperation());
            return new ResponseEntity<>("Success transfer", headers, HttpStatus.OK);
        }
    }
}
