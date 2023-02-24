package moneytransferservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class InfoTransfer {
    private Operation operation;
    private static int idOperation = 0;
    @Min(16)
    private String cardFromNumber;

    private String cardFromValidTill;

    @Min(3)
    private String cardFromCVV;
    @Min(16)
    private String cardToNumber;


    private Amount amount;

    private String resultOperation;

    public InfoTransfer(String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber, Amount amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
        idOperation++;

        @Size(min = 1, max = 12)
        String month = cardFromValidTill.split("/")[0];
    }

    @Override
    public String toString() {
        return "Информация о переводе: " +
                "карта списания='" + cardFromNumber + '\'' +
                ", карта зачисления='" + cardToNumber + '\'' +
                ", сумма =" + amount + '\'' +
                ", комиссия =" + amount.getValue() * 0.01 + " " + amount.getCurrency() + '\'' +
                ", результат операции = " + resultOperation;
    }

    public void setResultOperation(String resultOperation) {
        this.resultOperation = resultOperation;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        operation.setOperationId(String.valueOf(idOperation));
    }

    public Operation getOperation() {
        return operation;
    }

    public String getIdOperation() {
        return String.valueOf(idOperation);
    }
}
