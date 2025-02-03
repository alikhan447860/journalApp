
package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Service.EmailService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
@Autowired
private EmailService emailService;



    @Test
    void testSendMail() {
        emailService.sendEmail("carnation_duchess348@slmail.me",
                "Testing Java mail sender",
                "Hi, aap kaise hain ?");
    }
}
