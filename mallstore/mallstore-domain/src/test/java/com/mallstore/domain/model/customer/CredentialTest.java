package com.mallstore.domain.model.customer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DeKi on 3/16/2016.
 */
public class CredentialTest {

    private String username;
    private String password;

    @Before
    public void setUp() {
        this.username = "username";
        this.password = "password";
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullUsername() {
        Credential credential = new Credential(null, password);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullPassword() {
        Credential credential = new Credential(username, null);
    }

    @Test
    public void checkImmutability() {
        Credential credential = new Credential(username, password);
        credential.changeUsername("username2");
        credential.changePassword("password2");
        assertEquals("username", credential.getUsername());
        assertEquals("password", credential.getPassword());
    }

    @Test
    public void changeUsernameAndPassword() {
        Credential credential = new Credential(username, password);
        credential = credential.changeUsername("username2").changePassword("password2");
        assertEquals("password2",credential.getPassword());
        assertEquals("username2", credential.getUsername());
    }
}