package moneytransferservice.log;

import moneytransferservice.model.InfoTransfer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    protected static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(InfoTransfer infoTransfer) {
        Date date = new Date(System.currentTimeMillis());

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/java/moneytransferservice/log/resources/logger.txt", true), true)) {

            writer.println("[" + formatter.format(date) + " " + num++ + "] " + infoTransfer);


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

