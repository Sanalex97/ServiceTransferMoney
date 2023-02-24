FROM openjdk

EXPOSE 8080

ADD target/MoneyTransferService-0.0.1-SNAPSHOT.jar MyMoneyTransfer.jar

CMD ["java", "-jar", "MyMoneyTransfer.jar"]

