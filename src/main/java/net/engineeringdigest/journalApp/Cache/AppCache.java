package net.engineeringdigest.journalApp.Cache;

import net.engineeringdigest.journalApp.Reposetry.configjournalappReposetry;
import net.engineeringdigest.journalApp.entity.configjournalappEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    public enum keys{
        WEATHER_API;
    }

    @Autowired
    private configjournalappReposetry configJournalAppRepository;
    public Map<String,String>appcache=new HashMap<>();

    @PostConstruct
    public void init(){
        appcache = new HashMap<>();
        List<configjournalappEntity> all = configJournalAppRepository.findAll();
        for (configjournalappEntity configJournalAppEntity : all) {
            appcache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
    }


}
