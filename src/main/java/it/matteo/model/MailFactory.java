package it.matteo.model;

import java.util.Random;

import javax.mail.internet.AddressException;

public class MailFactory {

    static final String TEXT = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static Random rnd = new Random();

    public static Mail createSimpleMail(User sendTo, User sentFrom, int id, int textLength) throws AddressException {
        String object = "Autogenerated mail number [" + id + "]";
        String randomText = randomString(textLength);
        return new Mail(sendTo, sentFrom, object, randomText);
    }

    public static Mail createMailWithAttachment(User sendTo, User sentFrom, int id, int textLength, double attachmentSize) {
        String object = "Autogenerated mail number [" + id + "] with attachment of size [" + attachmentSize + "]";
        String randomText = randomString(textLength);
        Attachment attachment = new Attachment(String.valueOf(id), attachmentSize);
        Mail tempMail = new Mail(sendTo, sentFrom, object, randomText);
        tempMail.setAttachment(attachment);
        return tempMail;
    }

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(TEXT.charAt(rnd.nextInt(TEXT.length())));
        }
        return sb.toString();
    }

}
