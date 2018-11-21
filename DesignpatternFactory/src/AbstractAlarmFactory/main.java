package AbstractAlarmFactory;

public class main {
    public static void main(String[] args){
        AlarmanlagenFabrik fabrik1 = new TotalSicherheitsFabrik();

        Alarmanlage a1 = fabrik1.erstelleAlarmanlage("Haustüre");
        System.out.println(a1.getName());
    }
}
