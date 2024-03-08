package dao;

import com.sun.source.tree.WhileLoopTree;
import model.Movies;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements DAOInterface<Movies>{
    @Override
    public void Add(Movies movies) throws SQLException{
        String sql = "INSERT INTO Movies VALUES(?,?,?,?,?,?)";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,movies.getMovieId());
        ps.setString(2,movies.getTitle());
        ps.setString(3,movies.getDirector());
        ps.setDate(4, (Date) movies.getReleaseDate());
        ps.setString(5,movies.getGenre());
        ps.setInt(6,movies.getDurationMinutes());
        ps.executeUpdate();
    }
    @Override
    public void Delete(String ID) throws SQLException{
        String sql = "DELETE FROM Movies Where MovieID = ?";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,ID);
        ps.executeUpdate();
    }
    @Override
    public void Update (Movies movies, String ID) throws SQLException{
        String sql = "UPDATE Movies SET Title = ?, Director = ?, ReleaseDate = ?, Genre = ?, DurationMinutes = ? WHERE ID = ?";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1, movies.getTitle());
        ps.setString(2, movies.getDirector());
        ps.setDate(3,(Date) movies.getReleaseDate());
        ps.setString(4, movies.getGenre());
        ps.setInt(5,movies.getDurationMinutes());
        ps.setString(6, ID);
        ps.executeUpdate();
    }
    @Override
    public List<Movies> Statistical() throws SQLException{
        List<Movies> moviesList = new ArrayList<>();
        String sql = "SELECT * FROM Movies";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Movies movie = new Movies();
            movie.setMovieId(rs.getString("MovieID"));
            movie.setTitle(rs.getString("Title"));
            movie.setDirector(rs.getString("Director"));
            movie.setReleaseDate(rs.getDate("ReleaseDate"));
            movie.setGenre(rs.getString("Genre"));
            movie.setDurationMinutes(rs.getInt("DurationMinutes"));
            moviesList.add(movie);
        }
        return moviesList;
    }
    @Override
    public Movies Search(String ID) throws SQLException{
        String sql = "SELECT * FROM Movies WHERE ID = ?";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Movies movie = new Movies();
            movie.setMovieId(rs.getString("MovieID"));
            movie.setTitle(rs.getString("Title"));
            movie.setDirector(rs.getString("Director"));
            movie.setReleaseDate(rs.getDate("ReleaseDate"));
            movie.setGenre(rs.getString("Genre"));
            movie.setDurationMinutes(rs.getInt("DurationMinutes"));
            return movie;
        }
        return null;
    }
}
