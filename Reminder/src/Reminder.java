package btl_oop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class Reminder Thuc hien thao tao doc ghi File; quan ly cac ToDoList
 *
 * @author Nhom 2
 */
public final class Reminder {

    private static File folder = new File("DaTa");
    private List<Board> listBoards;

    /**
     * Ham khoi tao 
     */
    public Reminder() {
        listBoards = new ArrayList<>();
        if (!folder.exists()) {
            try {
                folder.mkdirs();
            } catch (Exception ex) {
                Logger.getLogger(Reminder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        loadData();

    }

    public List<Board> getList() {
        return listBoards;
    }

    public void setList(List<Board> list) {
        this.listBoards = list;
    }

    /**
     * Ham lay toan bo thong tin tu Folder DaTa
     *
     * @return true neu lay duoc thong tin
     */
    public boolean loadData() {
        String[] sListBoards = folder.list();
        for (String lBoard : sListBoards) {
            Board aBoards = new Board(lBoard);
            listBoards.add(aBoards);
        }

        for (Board aBoards : listBoards) {
            File subFolder = new File("DaTa/" + aBoards.getName());
            aBoards.dataFromFolder(subFolder);
        }
        return true;
    }

    /**
     * Ham tao mot bang cong viec
     * @param name
     * @return 
     */
    public Board createBoards(String name) {
        Board newBoards = new Board(name);
        listBoards.add(newBoards);
        return newBoards;
    }

    /**
     * Ham xoa mot bang cong viec
     * @param aB
     * @return 
     */
    public boolean removeABoards(Board aB) {
        File folder = new File("DaTa/" + aB.getName());
        int i = 0;
        for (ToDoList aL : aB.getList()) {
            File nfolder = new File("DaTa/" + aB.getName() + "/" + "reminder" + i);
            nfolder.delete();
            i++;
        }
        folder.delete();
        listBoards.remove(aB);
        return true;
    }

    /**
     * Ham luu du lieu chuong trinh
     */
    public void save() {
        for (Board aBoards : listBoards) {
            aBoards.saveBoards();
        }
    }

    /**
     * Ham tim kiem cong viec trong ngay
     * @return 
     */
    public ArrayList<Task> WorksOfToDay() {
        ArrayList<Task> l = new ArrayList<>();
        Date td1 = new Date();
        Date td2 = new Date();
        for (Board aB : listBoards) {
            for (ToDoList tdl : aB.getList()) {
                for (Task aTask : tdl.getList()) {
                    if (aTask.checkWorksInToDay()) {
                        l.add(aTask);
                    }
                }
            }
        }
        return l;
    }

}
