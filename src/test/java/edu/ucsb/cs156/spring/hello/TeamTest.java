
package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("test-team", team.getName());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_different_type() {
        assertFalse(team.equals("test-team"));
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_same_name_and_members() {
        Team other = new Team("test-team");
        assertTrue(team.equals(other));
    }

    @Test
    public void equals_different_name() {
        Team other = new Team("other-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_different_members() {
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_both_different() {
        Team other = new Team("other-team");
        other.addMember("Alice");
        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_returns_correct_value() {
        int expected = "test-team".hashCode() | new ArrayList<String>().hashCode();
        assertEquals(expected, team.hashCode());
    }

    @Test
    public void hashCode_equal_teams() {
        Team other = new Team("test-team");
        assertEquals(team.hashCode(), other.hashCode());
    }

    @Test
    public void default_constructor() {
        Team t = new Team();
        assertEquals("", t.getName());
        assertTrue(t.getMembers().isEmpty());
    }

    @Test
    public void setters_work() {
        team.setName("new-team");
        ArrayList<String> members = new ArrayList<>();
        members.add("Alice");
        team.setMembers(members);

        assertEquals("new-team", team.getName());
        assertEquals(members, team.getMembers());
    }
}