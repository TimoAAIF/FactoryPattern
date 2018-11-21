package AlarmFactory;

public class AlarmanlagenFabrik {
    public Alarmanlage macheneueAlarmanlage(String Typ){
        if(Typ.equals("Obergeschoss")){
            return new Obergeschossalarm();

        }else if(Typ.equals("Garten")){
            return new Gartenalarm();

        }else if(Typ.equals("Haustüre")){
            return new Haustueralarm();

        }else{
            return null;
        }
    }
}
