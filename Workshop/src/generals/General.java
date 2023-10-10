package generals;

public class General {
    private String name;
    private int motivation;

    public General(String name, int motivation) {
        this.name = name;
        this.motivation = motivation;
    }

    public int getMotivationLevel() {
        int output;
        if (motivation <= 25) {
            output = 0;
        } else if (motivation < 40) {
            output = 1;
        } else {
            output = 2;
        }

        return output;
    }

    public void punch(General general) {
        int damage = (int) Math.ceil(this.getMotivationLevel() / 1.5);
        if (this.getMotivationLevel() >= 1) {
            general.bePunched(damage);
        }
    }

    public void bePunched(int damage) {
        motivation -= (int) Math.ceil(damage / (motivation / 2.0));
        if (motivation < 0) {
            motivation = 0;
        }
    }

    @Override
    public String toString() {
        String output = "";
        if (getMotivationLevel() == 0) {
            output = String.format("%s is not motivated anymore.", name);
        } else if (getMotivationLevel() == 1) {
            output = String.format("%s is motivated.", name);
        } else {
            output = String.format("%s is well motivated.", name);
        }
        return output;
    }
}
