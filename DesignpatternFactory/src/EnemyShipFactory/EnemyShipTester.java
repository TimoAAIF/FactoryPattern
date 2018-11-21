package EnemyShipFactory;

import java.util.Scanner;

public class EnemyShipTester {

    public static void main(String[] args){
        EnemyShipFactory shipFactory = new EnemyShipFactory();

        Scanner scan = new Scanner(System.in);

        System.out.println("Welches Schiff soll erstellt werden?(U/R): ");
        String schiffstyp = scan.nextLine();

        EnemyShip gegner = shipFactory.makeEnemyShip(schiffstyp);

        if(gegner != null){
            gegner.shoot();
        }else{
            System.out.println("Bitte ein gültiges Schiff auswählen!");
        }

   }
}
