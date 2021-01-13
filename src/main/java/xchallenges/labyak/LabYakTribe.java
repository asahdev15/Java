package labyak;

public class LabYakTribe implements YakTribe {

    public boolean isAgeEligibleToShaveTribe(double currentAgeOfYakInDays) {
        return currentAgeOfYakInDays >= 100;
    }

    public boolean isYakAliveTribe(double currentAgeOfYakInDays) {
        return currentAgeOfYakInDays < 1000;
    }

    public double getNextShaveDayPeriodTribe(double currentAgeOfYakInDays) {
        return 8 + (currentAgeOfYakInDays * 0.01);
    }

    public double fetchMilkTribe(double currentAgeOfYakInDays) {
        return 50 - (currentAgeOfYakInDays * 0.03);
    }

}
