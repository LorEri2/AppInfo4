package model;

import java.util.List;

public class Character {
    private String name;
    private String role;
    private List<String> skills;

    public Character(String name, String role, List<String> skills) {
        this.name = name;
        this.role = role;
        this.skills = skills;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
    public List<String> getSkills() { return skills; }
}
