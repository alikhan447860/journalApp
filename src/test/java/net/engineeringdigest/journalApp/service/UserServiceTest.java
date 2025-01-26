package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Reposetry.UserRep;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    @Autowired
    private UserRep userRep;
    @Test
    public void addtest(){
        assertEquals(4,2+2);

    }


}
