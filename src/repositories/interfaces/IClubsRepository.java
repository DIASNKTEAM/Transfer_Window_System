package repositories.interfaces;

import entities.Clubs;

public interface IClubsRepository {
    //common account methods
    // method to get one user from db
    Clubs getClubByClubname(String clubname);

    //admin methods
    // method to create a new user in db
    boolean createClub(Clubs clubs);

    boolean withdrawMoney(int money_transferred, String from_clubname);
}
