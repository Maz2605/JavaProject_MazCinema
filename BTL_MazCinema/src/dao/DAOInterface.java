package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface <T>{
    public void Add(T t)throws SQLException;
    public void Delete(String ID) throws SQLException;
    public void Update(T t, String ID)throws SQLException;
    public List<T> Statistical() throws SQLException;
    public T Search(String ID)throws SQLException;
}
