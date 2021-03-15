package repositories;

import data.interfaces.IDB;
import entities.Budget;
import entities.Clubs;
import repositories.interfaces.IBudgetRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BudgetRepository implements IBudgetRepository {
    // constant variable to connect with database
    private final IDB db;

    // Constructor for creating a new BudgetRepository
    public BudgetRepository(IDB db) {
        this.db = db;
    }

    // method to create a new card for one clubname in db
    @Override
    public boolean createBudgetForClubname(String clubname) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String InsertStatement = "INSERT INTO budget(clubname, money_amount, valuta) VALUES (?,0,'');";
            PreparedStatement st = con.prepareStatement(InsertStatement);

            // Setting parameters into prepared SQL statement
            st.setString(1, clubname);

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

    // method to get a budget from db
    @Override
    public Budget getBudgetByClubname(String clubname) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM budget WHERE clubname=?";
            PreparedStatement st = con.prepareStatement(SelectStatement);

            st.setString(1, clubname);

            ResultSet rs = st.executeQuery();

            // if there is a result, do this
            if (rs.next()) {
                Budget budget = new Budget(
                        rs.getInt("id"),
                        rs.getString("clubname"),
                        rs.getInt("money_amount"),
                        rs.getString("valuta"));

                // return result budget from database
                return budget;
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



    @Override
    public Clubs getClubByClubname(String clubname) {
        return null;
    }

    // method to deposit some money into one budget
    @Override
    public boolean depositMoney(int money_amount, String clubname) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();


            Budget budget = getBudgetByClubname(clubname);
            money_amount += budget.getMoney_amount();

            // Creating SQL statement to deposit money into budget-number by username
            String UpdateStatement = "UPDATE budget SET money_amount = ? WHERE clubname = ?;";
            PreparedStatement st = con.prepareStatement(UpdateStatement);

            st.setInt(1, money_amount);
            st.setString(2, clubname);

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