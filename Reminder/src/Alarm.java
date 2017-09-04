/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_oop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Class Alarm
 * Tao luong thong bao cho cac task
 * @author nhom 2
 */
public class Alarm extends  Thread{

    private Reminder reminder;
   
    /**
     * Khoi tao mac dinh
     */
    public Alarm() {
        reminder = new Reminder();
    }
    /**
     * Khoi tao co tham so
     * @param reminder Doi tuong Reminder 
     */
    public Alarm(Reminder reminder){
        this.reminder = reminder;
    }
    
    /**
     * Ham duyet cac Task trong list
     * @param lis
     */
    public void notification(ArrayList<Task> aL){
            
            Date now = new Date( );
            for(Task aT : aL){
                if(aT.getNotification()){
                if((aT.getStartTime().getTime().getHours() == now.getHours()) 
                && (aT.getStartTime().getTime().getMinutes() == now.getMinutes())){
                        long deti = now.getSeconds() * 1000 ;
                        
                        NotificationFrame notifi = new NotificationFrame("ja",this,aT.showInformation(0));
                        notifi.action();
                       
                        try {
                            Thread.sleep(60000 - deti);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Alarm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        notifi.stop();
                }
                }
                
            }
     }

  
    /**
     * Ham chay Luong alarm
     */
    @Override
    public void run() {
        super.run(); 
        
        try{
            while(true){
                ArrayList<Task> aL =  reminder.WorksOfToDay();
                notification(aL);
                Thread.sleep(1000);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
    
  
    
}
