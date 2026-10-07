package model;

public class Song {
    private String title;
    private String artist;
    private String url;
    private boolean favorite;

    public Song() {}

    public Song(String title, String artist, String url, boolean favorite) {
        this.title = title;
        this.artist = artist;
        this.url = url;
        this.favorite = favorite;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public boolean isFavorite() { return favorite; }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }
}