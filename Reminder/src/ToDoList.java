package btl_oop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class ToDoList Mo ta mot danh sach cong viec
 *
 * @author nhom 2
 */
public class ToDoList {

    private String name;
    private Task cacheTask;
    private List<Task> list;

    /**
     * khoi tao mac dinh
     */
    public ToDoList() {
        name = "AList";
        list = new ArrayList<Task>();
    }

    /**
     * khoi tao co tham so
     * @param name Ten ToDoList
     */
    public ToDoList(String name) {
        this.name = name;
        list = new ArrayList<Task>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getList() {
        return list;
    }

    public void setList(ArrayList<Task> list) {
        this.list = list;
    }

    /**
     * Ham Xoa mot Note
     *
     * @param ANote Note can xoa
     */
    public void deleteATask(Task ANote) {
        list.remove(ANote);
    }

    /**
     * Ham them mot Task
     * @param n Task can them
     * @return Them duoc hay khong
     */
    public boolean addATask(Task n) {
        for (Task task : list) {
            if(n.getName().equals(task.getName()))
                return false;
        }
        if(n.getPriority() == 0)
            list.add(n);
        else if(n.getPriority() == 1){
            if(list.size() == 0)
                list.add(n);
            else{
                if(list.get(list.size()-1).getPriority() != 0)
                    list.add(n);
                else{
                        for(Task aT : list){
                            if(aT.getPriority() == 0){
                                list.add(list.indexOf(aT), n);
                                break;
                            }
                    }   
                }
                
            }
        }
        else if(n.getPriority() == 2){
            if(list.size() == 0)
                list.add(n);
            else{
                if(list.get(list.size()-1).getPriority() == 2)
                    list.add(n);
                else{
                     for(Task aT : list){
                            if(aT.getPriority() != 2){
                                list.add(list.indexOf(aT), n);
                                break;
                            }
                }
            }
        }
       
    }
         return true;
    }

    /**
     * Ham tao thong tin cho ToDoList tu 1 File
     *
     * @param f File luu thong tin cua ToDoList
     * @return true neu lay duoc thong tin
     */
    public boolean dataFromFile(File f) {
        try {
            FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            this.setName(line);

            line = br.readLine();

            while (line != null) {
                String nameFromFile = line;

                boolean[] repeatFromFile = new boolean[9];
                line = br.readLine();
                for (int i = 0; i < 9; i++) {
                    if (line.charAt(i) == '1') {
                        repeatFromFile[i] = true;
                    } else if (line.charAt(i) == '0') {
                        repeatFromFile[i] = false;
                    }
                }
                line = br.readLine();
                Time startTime = new Time();
                startTime.convertToDate(line);

                line = br.readLine();
                Time endTime = new Time();
                endTime.convertToDate(line);

                line = br.readLine();
                String placeFromFile = line;

                line = br.readLine();
                String contentFromFile = line;

                boolean statusFromFile = true;
                line = br.readLine();
                 if (line.equals("0")) {
                    statusFromFile = false;
                }
               

                line = br.readLine();
                int priorityFromFile = 0;
                if (line.equals("1")) {
                    priorityFromFile = 1;
                } else if (line.equals("2")) {
                    priorityFromFile = 2;
                }

                boolean notificationFromFile = true;
                line = br.readLine();
                 if (line.equals("0")) {
                    notificationFromFile = false;
                }
                
                line = br.readLine();

                Task newTask = new Task(nameFromFile, repeatFromFile, startTime, endTime, placeFromFile, contentFromFile, statusFromFile, priorityFromFile,notificationFromFile);
                list.add(newTask);
            }
            br.close();
            isr.close();
            fis.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    /**
     * Luu ToDoLis xuong file
     * @param Folder thu muc chua file
     * @param n so thu tu
     * @return co luu duoc hay khong
     */
    public boolean saveListToAFile(File Folder,int n){
        try {

            String fileName = "reminder" + n;
            FileOutputStream fileData = new FileOutputStream("DaTa/" + Folder.getName() + "/" + fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fileData);
            BufferedWriter br = new BufferedWriter(osw);
            br.write(this.getName());
            br.newLine();
            for (Task tip : this.getList()) {
                br.write(tip.getName());
                br.newLine();
                String informationRepeat = "";
                if(tip.getRepeat()[0] && tip.getRepeat()[1]){
                    for (int i = 0; i < 9; i++) {
                        informationRepeat += "1";
                    }
                }
                else{
                for (int i = 0; i < 9; i++) {
                    if (tip.getRepeat()[i]) {
                        informationRepeat += "1";
                    } else {
                        informationRepeat += "0";
                    }
                }
                }
                br.write(informationRepeat);
                br.newLine();

                br.write(tip.getStartTime().toStringTime());
                br.newLine();

                br.write(tip.getEndTime().toStringTime());
                br.newLine();

                br.write(tip.getPlace());
                br.newLine();

                br.write(tip.getContent());
                br.newLine();

                if (tip.getStatus()) {
                    br.write("1");
                } else {
                    br.write("0");
                }
                br.newLine();
                
                switch (tip.getPriority()) {
                    case 0:
                        br.write("0");
                        break;
                    case 1:
                        br.write("1");
                        break;
                    case 2:
                        br.write("2");
                        break;
                    default:
                        break;
                }
                br.newLine();
                
                if (tip.getNotification()) {
                    br.write("1");
                } else {
                    br.write("0");
                }
                br.newLine();
            }
             br.close();
                osw.close();
                fileData.close();
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     * Lay danh sach cac Task da hoan thanh
     * @return Danh sach Task
     */
    public ArrayList<Task> completeWorks(){
       ArrayList<Task> Works = new ArrayList<>();
       for(Task aT : list){
           if(aT.getStatus()){
                   Works.add(aT);
           }
       }
       return Works;
    }
    
    /**
     * Lay danh sach cac Task canh bao
     * @return Danh sach Task qua thoi han hoan thanh
     */
    public ArrayList<Task> warningWorks(){
       ArrayList<Task> Works = new ArrayList<>();
       for(Task aT : list){
          if(!aT.getRepeat()[0]){
            if(!aT.getStatus()){
               Date now = new Date();
               if(now.compareTo(aT.getEndTime().getTime()) >  0 ){
                   Works.add(aT);
               }
            }
          }
       }
       return Works;
    }
}