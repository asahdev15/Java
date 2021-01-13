package labyak;

public class YakFactory {

    public static Yak buildYak(YakType yakType, String name, double age, String sex) throws Exception{
        switch (yakType) {
            case LAB_YAK:
                return new LabYak(name, age, sex);
            default:
                throw new Exception("Other Yak Types are not BORN yet !!");
        }
    }
}
