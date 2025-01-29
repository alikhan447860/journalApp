package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Reposetry.UserRep;
import net.engineeringdigest.journalApp.Service.UserDetailServiceImpl;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.Reposetry.UserRep;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static  org.mockito.Mockito.*;

@ActiveProfiles("dev")
public class UserDetailServiceImplTest {

    @InjectMocks
    private UserDetailServiceImpl userDetailsService;

    @Mock
    private UserRep userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

//    @Disabled
    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("ram").password("inrinrick").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}