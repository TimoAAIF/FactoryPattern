package AbstractAlarmFactory;

/***
 * Die Klasse HochsicherheitsFabrik implementiert das Interface AlarmanlagenFabrik
 * der Klasse wird ein String mit einer gewünschten Alarmanlage gesendet
 * die Klasse übernimmt dann das erstellen und gibt eine passende Alarmanlage zurück
 */
public class HochsicherheitsFabrik implements AlarmanlagenFabrik {

    /**
     * erstellt eine passende Alarmanlage
     * @param name
     * @return Alarmanlage
     */
    @Override
    public Alarmanlage erstelleAlarmanlage(String name) {

        if(name.equals("Haustüre")){

            return new HochsicherheitsHaustüralarm();
        }else {
            return null;
        }
    }
}
