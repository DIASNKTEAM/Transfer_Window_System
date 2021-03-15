package entities;

public class Clubs {
    private String clubname;
    private String password;
    private boolean club_type;
    private String country;

    public String getClubname() {
        return clubname;
    }
    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isClub_type() {
        return club_type;
    }
    public void setClub_type(boolean club_type) {
        this.club_type =club_type;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Clubs(String clubname, String password, boolean club_type, String country) {
        setClubname(clubname);
        setPassword(password);
        setClub_type(club_type);
        setCountry(country);
    }

    public String getClubInfo() {
        String out = "";
        out += getClubname() + " | ";
        out += getPassword() + " | ";
        out += (isClub_type() ? "FIFA" : "Club") + " | ";
        out += getCountry() + " | ";
        return out;
    }
}

