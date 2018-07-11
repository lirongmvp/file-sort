package com.lirong.merge;

import java.util.List;

/**
 * 调度融合
 * @author LiRong
 */
public class Dispatch {

    private  List<String> filePathList;

    public void dispatch(List<String> list){
        this.filePathList=list;
    }

    public void canMerge(){
        FileMergeTrigger trigger =new FileMergeTriggerImpl();
        String merge = trigger.merge(filePathList);
        System.out.println(merge);
    }

}
