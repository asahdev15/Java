package labyak;


public class LabYak implements Yak{

    private String name;
    private double currentAge;
    private String sex;
    private int woolQuantity;
    private double milkFetched;
    private double nextDayToShave;
    private YakTribe YakTribe;

    public LabYak(){
    }

    public LabYak(String name, double currentAge, String sex) {
        this.name = name;
        this.currentAge = currentAge*100;
        this.sex = sex;
        this.YakTribe = new LabYakTribe();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getCurrentAge() {
        return currentAge/100;
    }

    public void setCurrentAge(double currentAge) {
        this.currentAge = currentAge*100;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getWoolQuantity() {
        return woolQuantity;
    }

    public void setWoolQuantity(int woolQuantity) {
        this.woolQuantity = woolQuantity;
    }

    public double getMilkFetched() {
        return milkFetched;
    }

    public void setMilkFetched(double milkFetched) {
        this.milkFetched = milkFetched;
    }

    @Override
    public String toString() {
        return "Yak{" +
                "name='" + name + '\'' +
                ", currentAge=" + currentAge +
                ", woolQuantity=" + woolQuantity +
                ", milkFetched=" + milkFetched +
                '}';
    }

    public void performMorningTask(int days){
        if(days>0){
            for(int i = 0 ; i < days  ; i++){
                if(i>0){
                    ++currentAge;
                }
                if(YakTribe.isYakAliveTribe(currentAge)){
                    fetchMilk();
                    shaveWool(i);
                }else{
                    break;
                }
            }
            ++currentAge;
        }
    }

    private void shaveWool(int currentDay){
        if(YakTribe.isAgeEligibleToShaveTribe(currentAge) && currentDay>0 && currentDay>nextDayToShave){
            ++woolQuantity;
            nextDayToShave = nextDayToShave + YakTribe.getNextShaveDayPeriodTribe(currentAge);
        }
    }

    private void fetchMilk(){
        milkFetched = milkFetched + YakTribe.fetchMilkTribe(currentAge);
    }

}
