package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private String owner;
    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public Playlist(String name, String owner, List<Song> songs) {
        this.name = name;
        this.owner = owner;
        this.songs = (songs != null) ? songs : new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public List<Song> getSongs() { return songs; }
    public void setSongs(List<Song> songs) { this.songs = songs; }
}