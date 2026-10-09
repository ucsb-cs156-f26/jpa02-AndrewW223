
package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()), "Constructor is not private");
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Andrew", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("AndrewW223", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f26-01", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("YiFan"));
        assertTrue(t.getMembers().contains("Jonathan"));
        assertTrue(t.getMembers().contains("Owen"));
        assertTrue(t.getMembers().contains("Christian"));
        assertTrue(t.getMembers().contains("Nathan"));
        assertTrue(t.getMembers().contains("Andrew"));
    }
}