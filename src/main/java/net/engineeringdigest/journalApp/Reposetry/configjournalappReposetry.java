package net.engineeringdigest.journalApp.Reposetry;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.entity.configjournalappEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface configjournalappReposetry extends MongoRepository<configjournalappEntity, String> {

}
