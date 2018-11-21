package AlarmFactory;

public abstract class Alarmanlage {
    private String name;
    private boolean status;
    private boolean alarm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    @Override
    public String toString() {
        return "Alarmanlage{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", alarm=" + alarm +
                '}';
    }
}
