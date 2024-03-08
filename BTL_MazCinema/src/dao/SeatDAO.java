package dao;

import model.Rooms;
import model.Seats;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO implements DAOInterface<Seats> {
    @Override
    public void Add(Seats seats) throws SQLException {
        String sql = "INSERT INTO Seats VALUES(?,?,?,?,?)";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,seats.getSeatId());
        ps.setString(2,seats.getRoomId());
        ps.setString(3,seats.getSeatNumber());
        ps.setString(4,seats.getRowName());
        ps.setBoolean(5,seats.isAvailable());
        ps.executeUpdate();
    }

    @Override
    public void Delete(String ID) throws SQLException {
        String sql = "DELETE FROM Seats Where SeatID = ?";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,ID);
        ps.executeUpdate();
    }

    @Override
    public void Update(Seats seat, String ID) throws SQLException {
        String sql = "UPDATE Seats SET RoomID = ?, SeatNumber = ?, RowName = ?, IsAvailable = ?  WHERE SeatID = ?";

        PreparedStatement ps =JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,seat.getSeatId());
        ps.setString(2,seat.getRoomId());
        ps.setString(3,seat.getSeatNumber());
        ps.setString(4,seat.getRowName());
        ps.setBoolean(5,seat.isAvailable());
        ps.executeUpdate();
    }

    @Override
    public List<Seats> Statistical() throws SQLException {
        List<Seats> SeatList = new ArrayList<>();
        String sql = "SELECT * FROM Seats";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Seats seat = new Seats();
            seat.setSeatId(rs.getString("SeatID"));
            seat.setRoomId(rs.getString("RoomID"));
            seat.setSeatNumber(rs.getString("SeatNumber"));
            seat.setRowName(rs.getString("RowName"));
            seat.setAvailable(rs.getBoolean("IsAvailable"));
            SeatList.add(seat);
        }
        return SeatList;
    }

    @Override
    public Seats Search(String ID) throws SQLException {
        String sql = "SELECT * FROM Seats WHERE ID = ?";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Seats seat = new Seats();
            seat.setSeatId(rs.getString("SeatID"));
            seat.setRoomId(rs.getString("RoomID"));
            seat.setSeatNumber(rs.getString("SeatNumber"));
            seat.setRowName(rs.getString("RowName"));
            seat.setAvailable(rs.getBoolean("IsAvailable"));
            return seat;
        }
        return null;
    }
}
