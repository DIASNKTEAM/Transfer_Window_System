package repositories;

import data.interfaces.IDB;
import entities.Clubs;
import repositories.interfaces.IClubsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClubsRepository implements IClubsRepository {
    // constant variable to connect with database
    private final IDB db;

    // Constructor for creating a new ClubRepository
    public ClubsRepository(IDB db) {
        this.db = db;
    }

    // method to get one club from db
    @Override
    public Clubs getClubByClubname(String clubname) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM clubs WHERE clubname=?";
            PreparedStatement st = con.prepareStatement(SelectStatement);

            st.setString(1, clubname);

            ResultSet rs = st.executeQuery();

            // if there is a result, do this
            if (rs.next()) {
                Clubs clubs = new Clubs(
                        rs.getString("clubname"),
                        rs.getString("password"),
                        rs.getBoolean("club_type"),
                        rs.getString("country"));

                // return result club from database
                return clubs;
            }
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

    // method to create a new club in db
    @Override
    public boolean createClub(Clubs clubs) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String InsertStatement = "INSERT INTO clubs(clubname, password, club_type, country) VALUES (?,?,?,?);";
            PreparedStatement st = con.prepareStatement(InsertStatement);

            // Setting parameters into prepared SQL statement
            st.setString(1, clubs.getClubname());
            st.setString(2, clubs.getPassword());
            st.setBoolean(3, clubs.isClub_type());
            st.setString(4, clubs.getCountry());

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

    @Override
    public boolean withdrawMoney(int money_transferred, String from_clubname) {
        return false;
    }

}
