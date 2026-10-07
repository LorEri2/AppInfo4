package web;

import model.Playlist;
import model.Song;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/playlist")
public class PlaylistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Bohemian Rhapsody", "Queen", "https://www.youtube.com/watch?v=fJ9rUzIMcZQ", true));
        songs.add(new Song("Starboy", "The Weeknd", "https://www.youtube.com/watch?v=34Na4j8AVgA", false));
        songs.add(new Song("Billie Jean", "Michael Jackson", "https://www.youtube.com/watch?v=Zi_XLOBDo_Y", false));

        Playlist playlist = new Playlist("Road Trip Classics", "Alex", songs);

        request.setAttribute("playlist", playlist);
        request.getRequestDispatcher("/Playlist.jsp").forward(request, response);
    }
}