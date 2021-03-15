package repositories;

import entities.Transfers;
import repositories.TransfersRepository;
import data.interfaces.IDB;
import repositories.interfaces.ITransfersRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TransfersRepository implements ITransfersRepository {
    // constant variable to connect with database
    private final IDB db;

    // Constructor for creating a new TransferRepository
    public TransfersRepository(IDB db) {
        this.db = db;
    }

    // method to get transfers by clubname from db
    @Override
    public List<Transfers> getTransferByClubname(String clubname) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM transfers WHERE from_clubname=?";
            PreparedStatement st = con.prepareStatement(SelectStatement);

            st.setString(1, clubname);

            ResultSet rs = st.executeQuery();

            List<Transfers> transfers = new LinkedList<>();

            // while there is a result, do this
            while (rs.next()) {
                Transfers transfer = new Transfers(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("from_clubname"),
                        rs.getString("to_clubname"),
                        rs.getInt("money_transferred"));

                transfers.add(transfer);
            }

            // result result transaction list from database
            return transfers;
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return null, if nothing happens
        return null;
    }



    // method to create a new transaction in db
    @Override
    public boolean createTransfer(Transfers transfers) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String InsertStatement = "INSERT INTO transfers(date, from_clubname, to_clubname, money_transferred) VALUES (?,?,?,?);";
            PreparedStatement st = con.prepareStatement(InsertStatement);

            // Setting parameters into prepared SQL statement
            st.setDate(1, java.sql.Date.valueOf(transfers.getDate()));
            st.setString(2, transfers.getFrom_clubname());
            st.setString(3, transfers.getTo_clubname());
            st.setInt(4, transfers.getMoney_transferred());


            // executing SQL statement in database
            st.execute();

            // if everything is successfully done, return true
            return true;
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return false, if nothing happens
        return false;
    }
}
