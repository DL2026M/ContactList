public class KitchenStaff extends Person {
    private double salary;
    private int skillLevel;
    private String favoriteMeal;

    public KitchenStaff(String firstName, String lastName, String phoneNumber,
                        double salary, int skillLevel, String favoriteMeal) {
        super(firstName, lastName, phoneNumber);
        this.salary = salary;
        this.skillLevel = skillLevel;
        this.favoriteMeal = favoriteMeal;
    }

    public double getSalary() {
        return salary;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getFavoriteMeal() {
        return favoriteMeal;
    }
    public String toString() {
        return super.toString() + " Salary: $" + this.salary + " Skill Level: \n"
                + this.skillLevel + " Favorite Meal: " + this.favoriteMeal;
    }
}
