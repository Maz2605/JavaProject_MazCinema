package dao;

import model.Sceenings;

import java.sql.SQLException;
import java.util.List;

public class SceeningDAO implements DAOInterface<Sceenings> {
    @Override
    public void Add(Sceenings sceenings) throws SQLException {
        String sql  = "INSERT INTO "
    }

    @Override
    public void Delete(String ID) throws SQLException {

    }

    @Override
    public void Update(Sceenings sceenings, String ID) throws SQLException {

    }

    @Override
    public List<Sceenings> Statistical() throws SQLException {
        return null;
    }

    @Override
    public Sceenings Search(String ID) throws SQLException {
        return null;
    }
}
