package model.character;

public class Felicity {
    private String name;
    private String dorm;
    private String race;
    private int height;
    private String grade;
    private String favoriteSnack;


    public Felicity() {
        name = "Felicity";
        dorm = "Totem Park";
        race = "Asian";
        height = 165;
        grade = "First Year Student";
        favoriteSnack = "Candy";
    }


    public String getName() {
        return name;
    }

    public String getDorm() {
        return dorm;
    }

    public String getRace() {
        return race;
    }


    public int getHeight() {
        return height;
    }


    public String getGrade() {
        return grade;
    }


    public String getFavoriteSnack() {
        return favoriteSnack;
    }

}
