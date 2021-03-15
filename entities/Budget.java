package entities;

public class Budget {
    // unique id of budget
    private int id;
    // every club has own budget
    private String clubname;
    // amount of money
    private int money_amount;
    // the valuta of the money
    private String valuta;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getClubname() {
        return clubname;
    }
    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public int getMoney_amount() {
        return money_amount;
    }
    public void setMoney_amount(int money_amount) {
        this.money_amount = money_amount;
    }

    public String getValuta() {
        return valuta;
    }
    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public Budget(int id, String clubname, int money_amount, String valuta) {
        setId(id);
        setClubname(clubname);
        setMoney_amount(money_amount);
        setValuta(valuta);
    }

    public Budget(String clubname, int money_amount, String valuta) {
        setClubname(clubname);
        setMoney_amount(money_amount);
        setValuta(valuta);
    }
    public String getBudgetInfo() {
        String out = "";
        out += getId() + " | ";
        out += getClubname() + " | ";
        out += getMoney_amount() + " | ";
        out += getValuta() + " | ";
        return out;
    }
}
