package com.lirong.merge;

import java.util.List;

/**
 * @author LiRong
 */
public class Dispatch {

    private  List<String> filePathList;

    public void dispatch(List list){
        this.filePathList=list;
    }

    public void canMeger(){
        FileMergeTriggerImpl.merge(filePathList);
    }

}
