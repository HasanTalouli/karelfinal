import kareltherobot.*;
/**
 * Write a description of class KarelWorker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WindowCloser extends Robot implements Directions
{
    
    public WindowCloser(int st, int ave, Direction dir, int beeps)
    {
        super(st, ave, dir, beeps);
    }
    
    public static void main(String[] args){
        World.reset();
        World.setDelay(2);
        World.readWorld("windowWorld.kwld");
        World.setTrace(true);
        World.setVisible(true);
        
        WindowCloser george=new WindowCloser(7,5,East,infinity);
        george.work();
    }
    
    public void work(){
        putBeeper();
        move();
        while(!nextToABeeper()){
            if(!leftIsClear()){
                putBeeper();
            }
            
            if(frontIsClear()){
                move();
            }
            else{
               moveToNextWindow();
            }
        }
        pickBeeper();
        
        if(!leftIsClear()){
            putBeeper();
        }
    }
    
    public void turnRight(){ 
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void moveToNextWindow(){
        turnRight();
        move();
    }
    
    public boolean leftIsClear(){
        boolean result=false;
        
        turnLeft();
        
        if(!frontIsClear()){
            result=true;
        }
        
        turnRight();
        
        return result;
    }
}