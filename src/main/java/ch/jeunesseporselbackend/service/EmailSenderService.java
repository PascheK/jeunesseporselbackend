package ch.jeunesseporselbackend.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmailSenderService {
    boolean sendSimpleEmail(String mailTo, String subject, Map<String, Object> model) throws Exception;
}
