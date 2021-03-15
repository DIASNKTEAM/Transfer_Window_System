import controllers.ClubsController;
import data.DB;
import data.interfaces.IDB;
import repositories.BudgetRepository;
import repositories.TransfersRepository;
import repositories.ClubsRepository;
import repositories.interfaces.IBudgetRepository;
import repositories.interfaces.ITransfersRepository;
import repositories.interfaces.IClubsRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new DB();
        IBudgetRepository card_repo = new BudgetRepository(db);
        IClubsRepository user_repo = new ClubsRepository(db);
        ITransfersRepository trans_repo = new TransfersRepository(db);
        ClubsController controller = new ClubsController(user_repo, card_repo, trans_repo);

        MyApplication app = new MyApplication(controller);
        // start application
        app.start();
    }
}
