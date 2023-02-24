package moneytransferservice.model;

public class Operation {
    private String operationId;
    transient private String code;


    public Operation(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Номер операции='" + operationId + '\'' + ", Секретный код='" + code;
    }
}
