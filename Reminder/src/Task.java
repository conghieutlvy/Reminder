package btl_oop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Task
 * Mo ta mot cong viec(Task)
 * @author nhom 2
 */
public class Task {

    /**
     * Ten cua Task
     */
    private String name; 
    /**
     * Dia Diem
     */
    private String place;
    /**
     * Trang thai
     */
    private boolean status;
    /**
     * Thoi gian bat dau
     */
    private Time endTime;
    /**
     * Thoi gain ket thuc
     */
    private Time startTime;
    /**
     * Noi Dung cua Task
     */
    private String content;
    /**
     * Trang Thai lap lai hay khong
     */
    private boolean[] repeat;

    /**
     * Trang thai thong bao
     */
    private boolean notification;

   
    /**
     * Muc do uu tien cong viec
     */
    private int priority;

    public int getPriority() {
        return priority;
    }
    /**
     * Ham Khoi tao mac dinh
     */
    public Task() {

    }
    public Task(Task t) {
        this.name = t.getName();
        this.place = t.getPlace();
        this.status = t.getStatus();
        this.endTime = t.getEndTime();
        this.startTime = t.getStartTime();
        this.repeat = t.getRepeat();
        this.content = t.getContent();
        this.priority = t.getPriority();
        this.notification = t.getNotification();
    }
    /**
     * Ham khoi tao co tham so
     * @param name ten
     * @param repeat Lap lai
     * @param startTime Thoi Gian bat dau
     * @param endTime Thoi gian ket thuc 
     * @param place Dia Diem
     * @param content Noi Dung
     * @param status Trang Thai
     * @param priority muc do uu tien
     * @param notification Thong bao
     */
    public Task(String name, boolean[] repeat, Time startTime, Time endTime, String place, String content, boolean status,int priority,boolean notification) {
        this.name = name;
        this.place = place;
        this.status = status;
        this.endTime = endTime;
        this.startTime = startTime;
        this.repeat = repeat;
        this.content = content;
        this.priority = priority;
        this.notification = notification;
    }
    /**
     * Ham khoi tao co tham so
     * @param s Ten Task
     */
    public Task(String s) {
        this.name = s;
        this.place = "";
        this.status = false;
        this.endTime = new Time();
        this.startTime = new Time();
        this.repeat = new boolean[9];
        for (int i = 0; i < 9; i++) {
            repeat[i] = false;
        }
        this.content = "";
        this.priority = 0;
        this.notification = true;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public boolean[] getRepeat() {
        return repeat;
    }

    public void setRepeat(boolean[] repeat) {
        this.repeat = repeat;
    }

    /**
     * Ham tao gia tri cua phan tu mang reapeat them so thu tu
     * @param b 
     * @param n 
     */
    public void setRepeat(boolean b, int n) {
        if (n < 9 && n >= 0) {
            repeat[n] = b;
        }
        if (n == 0 && !b) {
            for (int i = 1; i < 9; i++) {
                repeat[i] = false;
            }
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

     public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public boolean getNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }
   
    /**
     * In toan bo thong tin
     * @return Chuoi String chua toan bo thong tin cua Task
     */
    public String showInformation(int st) {
        String informationOfTask = "";
        informationOfTask += (name);
        informationOfTask += "\n";
        informationOfTask += ("place: " + place);
        informationOfTask += "\n";

        informationOfTask += "Time: ";
        informationOfTask += "\n";
        if (!repeat[0]) {
            informationOfTask += ("StartTime: " + startTime.toStringTime1());
            informationOfTask += "\n";
            informationOfTask += ("EndTime: " + endTime.toStringTime1());
        } else if (repeat[0] && !repeat[1]) {
            informationOfTask += ("StartTime: " + startTime.toStringTimeHM());
            informationOfTask += "\n";
            informationOfTask += ("EndTime: " + endTime.toStringTimeHM());
            informationOfTask += "\n";
            informationOfTask += "DayofWeek: ";
            for (int i = 2; i < 9; i++) {
                if (repeat[i]) {
                    switch (i) {
                        case 2:
                            informationOfTask += " Mon ";
                            break;
                        case 3:
                            informationOfTask += " Tue ";
                            break;
                        case 4:
                            informationOfTask += " Wen ";
                            break;
                        case 5:
                            informationOfTask += " Thu ";
                            break;
                        case 6:
                            informationOfTask += " Fri ";
                            break;
                        case 7:
                            informationOfTask += " Sat ";
                            break;
                        case 8:
                            informationOfTask += " Sun ";
                            break;
                    }
                }
            }
        } else if (repeat[0] && repeat[1]) {
            informationOfTask += ("StartTime: " + startTime.toStringTimeHM());
            informationOfTask += "\n";
            informationOfTask += ("EndTime: " + endTime.toStringTimeHM());
            informationOfTask += "\n";
       }
         if(st != 0){
         informationOfTask += "\n";
        switch(priority){
            case 0 : 
                 informationOfTask += "priority : Nomal";
                 break;
            case 1 : 
                 informationOfTask += "priority : Medium";
                 break;
            case 2 : 
                 informationOfTask += "priority : High";
                 break;
        }
        }
        return informationOfTask;
    }
    /**
     * Kiem tra xem Task co duoc thuc hien vao hom nay khong
     * @return 
     */
   public boolean checkWorksInToDay() {
        if(status){
            return false;
        }
        else{
        Date today = new Date();
        today.setHours(23);
        today.setMinutes(59);
        today.setSeconds(59);
        
        Date today1 = new Date();
        today1.setHours(0);
        today1.setMinutes(0);
        today1.setSeconds(0
        
        );
        if (!repeat[0] && !repeat[1]) {
            if ((today.compareTo(startTime.getTime()) >= 0) && (today1.compareTo(endTime.getTime()) <= 0)) {
                return true;
            }
        } else {
            if (repeat[today.getDay() + 1] || (repeat[8] && today.getDay() == 0)) {
                return true;
            }
            
        }
        }
        return false;
    }
    
    /**
     * Ham kiem tra thoi gian(dung de thong bao)
     * @return true neu dung thoi gian
     */
    public boolean notice() {

        Date now = new Date();
        DateFormat format = new SimpleDateFormat("mm HH dd MM yyyy");
        DateFormat formatHM = new SimpleDateFormat("mm HH");
        if(!repeat[0]){
            if(format.format(now).equals(format.format(endTime.getTime())))
                return true;
        }
        else if(repeat[0]){
            if(formatHM.format(now).equals(formatHM.format(endTime.getTime())) && repeat[now.getDay()+1])
                return true;
            if(formatHM.format(now).equals(formatHM.format(endTime.getTime())) && repeat[8] && now.getDay() == 0)
                return true;
        }
        return false;
    }
}
