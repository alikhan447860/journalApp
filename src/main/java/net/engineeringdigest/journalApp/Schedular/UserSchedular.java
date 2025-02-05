package net.engineeringdigest.journalApp.Schedular;

import net.engineeringdigest.journalApp.Cache.AppCache;
import net.engineeringdigest.journalApp.Reposetry.UserRepoImpl;
import net.engineeringdigest.journalApp.Service.EmailService;
import net.engineeringdigest.journalApp.Service.SentimentAnalysisService;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserSchedular {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepoImpl userRepository;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private AppCache appCache;

    // Scheduled to run every minute (for demonstration)
    @Scheduled(cron = "0 * * * * *")
    public void fetchUsersAndSendSaMail() {
        // Fetch users who need to be sent an email
        List<User> users = userRepository.getUserForSA();

        for (User user : users) {
            // Filter journal entries from the last 7 days
            List<String> sentiments = user.getJournalentries().stream()
                    .filter(entry -> entry.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS)))
                    .map(JournalEntry::getContent)
                    .collect(Collectors.toList());

            // If there are entries, send an email
            if (!sentiments.isEmpty()) {
                String emailContent = "Your weekly journal summary:\n" + String.join("\n", sentiments);
                emailService.sendEmail(user.getEmail(), "Weekly Journal Summary", emailContent);
            }
        }
    }

    // Scheduled to run every minute (for demonstration)
    @Scheduled(cron = "0 * * * * *")
    public void clearAppCache() {
        appCache.init();
    }
}
