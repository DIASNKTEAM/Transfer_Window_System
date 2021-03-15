package controllers;

import entities.*;
import repositories.interfaces.IBudgetRepository;
import repositories.interfaces.IClubsRepository;
import repositories.interfaces.ITransfersRepository;

import java.util.List;

public class ClubsController {
    private final IClubsRepository clubs_repo;
    private final IBudgetRepository budget_repo;
    private final ITransfersRepository trans_repo;

    // Constructor for creating a new ClubsController
    public ClubsController(IClubsRepository clubs_repo, IBudgetRepository budget_repo, ITransfersRepository trans_repo) {
        this.clubs_repo = clubs_repo;
        this.budget_repo = budget_repo;
        this.trans_repo = trans_repo;
    }

    // common method for all clubs to get info account
    public Clubs getClubs(String clubname) {
        Clubs clubs = clubs_repo.getClubByClubname(clubname);

        return clubs;
    }

    // method just for admin club to create club account
    public String createClub(Clubs clubs) {
        boolean clubs_created = clubs_repo.createClub(clubs);
        boolean budget_created;
        if (clubs.isClub_type()) {
            budget_created = true;
        } else {
            budget_created = budget_repo.createBudgetForClubname(clubs.getClubname());
        }

        return (clubs_created && budget_created ? "Football club is successfully created in database!" : "Club addition was failed!");
    }

    // method for clubs to get information about their budgets
    public String getBudgetInfo(String clubname) {
        Budget budget = budget_repo.getBudgetByClubname(clubname);

        return budget.getBudgetInfo();
    }

    public String transferMoney(String from_clubname, String to_clubname, int money_transferred) {
        boolean transfered;
        boolean transfer_created;

        if (budget_repo.depositMoney(money_transferred, to_clubname) && clubs_repo.withdrawMoney(money_transferred, from_clubname)) {
            transfered = true;
            transfer_created = trans_repo.createTransfer(new Transfers(java.time.LocalDate.now(),from_clubname,to_clubname, money_transferred));
        }
        else {
            transfered = false;
            transfer_created = false;
        }

        return (transfered && transfer_created ? "Money transfer was failed!" : "Money transfer is successfully done!");
    }
}
