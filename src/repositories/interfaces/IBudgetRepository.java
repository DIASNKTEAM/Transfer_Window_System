package repositories.interfaces;

import entities.Budget;
import entities.Clubs;

public interface IBudgetRepository {
    // method to create a new budget for one clubname in db
    boolean createBudgetForClubname(String clubname);
    // method to get a budget from db
    Clubs getClubByClubname(String clubname);
    // method to deposit some money into one budget
    boolean depositMoney(int money, String clubname);

    Budget getBudgetByClubname(String clubname);
}
