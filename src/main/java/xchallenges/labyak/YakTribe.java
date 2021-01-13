package labyak;

public interface YakTribe {

    boolean isAgeEligibleToShaveTribe(double currentAgeOfYakInDays);

    boolean isYakAliveTribe(double currentAgeOfYakInDays);

    double getNextShaveDayPeriodTribe(double currentAgeOfYakInDays);

    double fetchMilkTribe(double currentAgeOfYakInDays);

}
