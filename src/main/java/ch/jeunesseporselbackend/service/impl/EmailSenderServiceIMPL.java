package ch.jeunesseporselbackend.service.impl;

import ch.jeunesseporselbackend.service.EmailSenderService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

@Service
public class EmailSenderServiceIMPL implements EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private Configuration configuration;

    @Override
    public boolean sendSimpleEmail(String mailTo, String subject, Map<String, Object> model, String template) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    "UTF-8");
            Template t = configuration.getTemplate(template);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            helper.setTo(mailTo);
            helper.setCc("info@jeunessedeporsel.ch");
            helper.setText(html, true);
            helper.setSubject(subject);
            helper.setFrom("info@jeunessedeporsel.ch");
            mailSender.send(mimeMessage);
            return true;
        } catch (MessagingException | IOException | TemplateException e) {
            throw new Exception(e.getMessage());
        }
    }
}
