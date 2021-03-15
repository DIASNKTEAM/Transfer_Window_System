package entities;

import java.time.LocalDate;

public class Transfers {
    private int id;
    // transaction date when happened it
    private LocalDate date;
    // who send money
    private String from_clubname;
    // whom money is sent
    private String to_clubname;
    // how much money is sent
    private int money_transferred;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFrom_clubname() {
        return from_clubname;
    }
    public void setFrom_clubname(String from_clubname) {
        this.from_clubname = from_clubname;
    }

    public String getTo_clubname() {
        return to_clubname;
    }
    public void setTo_clubname(String to_clubname) {
        this.to_clubname = to_clubname;
    }

    public int getMoney_transferred() {
        return money_transferred;
    }
    public void setMoney_transferred(int money) {
        this.money_transferred = money_transferred;
    }

    // constructor to create a new Transaction
    public Transfers(LocalDate date, String from_clubname, String to_clubname, int money_transferred) {
        setDate(date);
        setFrom_clubname(from_clubname);
        setTo_clubname(to_clubname);
        setMoney_transferred(money_transferred);
    }
    // constructor to create a new Transaction with id
    public Transfers(int id, LocalDate date, String from_clubname, String to_clubname, int money_transferred) {
        setId(id);
        setDate(date);
        setFrom_clubname(from_clubname);
        setTo_clubname(to_clubname);
        setMoney_transferred(money_transferred);
    }

    // method to get whole info about transaction
    public String getTransferInfo() {
        String out = "";
        out += getId() + " | ";
        out += getDate() + " | ";
        out += getFrom_clubname() + " | ";
        out += getTo_clubname() + " | ";
        out += getMoney_transferred() + " | ";
        return out;
    }
}
