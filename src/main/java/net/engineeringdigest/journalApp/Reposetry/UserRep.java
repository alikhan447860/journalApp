package net.engineeringdigest.journalApp.Reposetry;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRep extends MongoRepository<User, String> {
 User findByUserName(String username);
 void deleteByUsername(String username); // Fixed method name to match the field
}
