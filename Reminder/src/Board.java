/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_oop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Board
 * Mo ta bang cong viec
 * @author nhom 2
 */
public class Board {
    private String name;
    private List<ToDoList> list;

    /**
     * Ham khoi tao mac dinh
     */
    public Board(){
        list = new ArrayList<>();

    }
    
    /**
     * Ham khoi tao co tham so
     * @param name Ten cua bang cong viec
     */
    public Board(String name){
        this.name = name;
        list = new ArrayList<>();

    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ToDoList> getList() {
        return list;
    }

    public void setList(List<ToDoList> list) {
        this.list = list;
    }


    
    public void addAToDoList(ToDoList tdl){
        list.add(tdl);
    }
    /**
     * Lay thong tin tu Folder nap vao Bang cong viec
     * @param fd Folder chua thong tin bang cong viec
     */
    public void dataFromFolder(File fd){
        for(String filetxt : fd.list()){
            File txt = new File("DaTa/" + name + "/" + filetxt);
            ToDoList aList = new ToDoList();
            aList.dataFromFile(txt);
            addAToDoList(aList);
        }
    }
    /**
     * Luu thong tin cua bang cong viec vao Folder
     */
    public void saveBoards(){
        File foldersav = new File("DaTa/" + this.name);
        if(!foldersav.exists()){
            foldersav.mkdir();
        }
        int n = 0;
        for(ToDoList lists : list ){
            lists.saveListToAFile(foldersav, n);
            n++;
        }
    }
}
