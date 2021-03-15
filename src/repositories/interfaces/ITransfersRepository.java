package repositories.interfaces;

import entities.Transfers;

import java.util.List;

public interface ITransfersRepository {
    // method to get transfers by username from db
    List<Transfers> getTransferByClubname(String clubname);
    // method to create a new transfer in db
    boolean createTransfer(Transfers transfers);
}
