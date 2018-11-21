package EnemyShipFactory;

public class EnemyShipFactory {
    public EnemyShip makeEnemyShip(String newShipType){
        EnemyShip newShip = null;

        if(newShipType.equals("U")){
            return new UFO();
        }else if(newShipType.equals("R")){
            return new Rakete();
        }else{
            return null;
        }
    }
}
