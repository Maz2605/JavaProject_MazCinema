package dao;

import model.Rooms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements DAOInterface<Rooms>{


    @Override
    public void Add(Rooms room) throws SQLException{
        String sql = "INSERT INTO Rooms VALUES(?,?,?)";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,room.getRoomId());
        ps.setString(2,room.getRoomName());
        ps.setInt(3,room.getCapacity());
        ps.executeUpdate();
    }

    @Override
    public void Delete(String ID)throws SQLException{
        String sql = "DELETE FROM Room WHERE RoomID = ?";

        PreparedStatement ps =JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,ID);
        ps.executeUpdate();
    }
    @Override
    public void Update(Rooms room, String ID) throws SQLException{
        String sql = "UPDATE Rooms SET RoomName = ?, Capacity = ? WHERE RoomID = ?";

        PreparedStatement ps =JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,room.getRoomName());
        ps.setInt(2,room.getCapacity());
        ps.setString(3,ID);
        ps.executeUpdate();
    }
    @Override
    public List<Rooms> Statistical() throws SQLException{
        List<Rooms> RoomList = new ArrayList<>();
        String sql = "SELECT * FROM Rooms";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Rooms room = new Rooms();
            room.setRoomId(rs.getString("RoomID"));
            room.setRoomName(rs.getString("RoomName"));
            room.setCapacity(rs.getInt("Capacity"));
            RoomList.add(room);
        }
        return RoomList;
    }

    @Override
    public Rooms Search(String ID) throws SQLException{
        String sql = "SELECT * FROM Rooms WHERE RoomID = ?";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Rooms room = new Rooms();
            room.setRoomId(rs.getString("RoomID"));
            room.setRoomName(rs.getString("RoomName"));
            room.setCapacity(rs.getInt("Capacity"));
            return room;
        }
        return null;
    }
}
