package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Accounts;

public class AccountDAO implements DAOInterface<Accounts>{
    @Override
    public void Add(Accounts accounts) throws SQLException {
        String sql = "INSERT INTO Account VALUES(? , ? , ?)";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1, accounts.getUserName());
        ps.setString(2, accounts.getPassword());
        ps.setString(3, accounts.getRole());
        ps.executeUpdate();
    }
    @Override
    public void Delete(String ID) throws SQLException {
        String sql = "DELETE FROM Accounts WHERE AccountID=?";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,ID);
        ps.executeUpdate();
    }

    @Override
    public void Update(Accounts accounts, String ID) throws SQLException {
        String sql = "UPDATE Account SET Password = ? WHERE Username = ?";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1, accounts.getPassword());
        ps.setString(2, accounts.getUserName());
        ps.executeUpdate();
    }

    @Override
    public List<Accounts> Statistical() throws SQLException {
        List<Accounts> listAcc = new ArrayList<>();
        String sql = "SELECT * FROM Account";

        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            Accounts accounts = new Accounts();
            accounts.setUserName(rs.getString("UserName"));
            accounts.setPassword(rs.getString("Password"));
            accounts.setRole(rs.getString("Role"));
            listAcc.add(accounts);
        }
        return listAcc;
    }

    @Override
    public Accounts Search(String username) throws SQLException {
        String sql = "SELECT * FROM Accounts WHERE UserName = ?";

        PreparedStatement ps =JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Accounts account = new Accounts();
            account.setUserName(rs.getString("UserName"));
            account.setPassword(rs.getString("Password"));
            account.setRole(rs.getString("Role"));
            return account;
        }
        return null;
    }


}
