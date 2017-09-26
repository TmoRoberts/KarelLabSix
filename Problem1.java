
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    public int beepers; 
    public int rows;
    public int storage;
    int [] beeperRows = new int[8];
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
      startingPosition();
      while (rows <= 7) {
        collectBeepers();
        reposition();
        rows++;
      } 
      rows = 0;
      System.out.println("");
      for (int i = 0; i < beeperRows.length; i++) {
          System.out.print(beeperRows[i] + ",");
        }
      for (int i = 0; i < beeperRows.length; i++) {
          if (beeperRows[rows] <= beeperRows[rows + 1]) {
              beeperRows[rows] = beeperRows[rows];
            }
            else {
                storage = beeperRows[rows];
                
            }
        }
      for (int i = 0; i < beeperRows.length; i++) {
          System.out.print(beeperRows[i] + ",");
      }
    }
    public void collectBeepers() {
        while (nextToABeeper()) {
            pickBeeper();
            move();
            beepers++;
        }
        beeperRows[rows] = beepers;
        beepers = 0;
    }
    public void startingPosition() {
        move();
        turnLeft();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
        turnLeft();
    }
    public void reposition() {
        turnRight();
        move();
        turnRight();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
        turnLeft();
    }
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}

