package net.engineeringdigest.journalApp.Service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.Reposetry.UserRep;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
@Autowired
    private UserRep userrep;

private  static  final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
public void saveNewUser(User user){
    try {
        user.setRoles(Arrays.asList("USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userrep.save(user);
    }catch (Exception e){
        log.info("Hahahaha");
        return;
    }

}
    public void saveAdmin(User user){
        user.setRoles(Arrays.asList("USER","ADMIN"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userrep.save(user);
    }
public  void saveEntry(User user){

    userrep.save(user);
}
public List<User> getAll(){
    return userrep.findAll();
}
public Optional <User> findById(ObjectId id){

    return userrep.findById(String.valueOf(id));
}
public void deletById(ObjectId id){
    userrep.deleteById(String.valueOf(id));
}

    public User findByUsername(@NonNull String username) {
    return  userrep.findByUsername(username);
    }
}

//controller--->service--->repository calling process