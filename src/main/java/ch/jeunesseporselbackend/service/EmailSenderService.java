package ch.jeunesseporselbackend.service;


import java.util.Map;

public interface EmailSenderService {
    boolean sendSimpleEmail(String mailTo, String subject, Map<String, Object> model, String template) throws Exception;
}
