package net.engineeringdigest.journalApp.Reposetry;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.ObjectInput;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {


}
