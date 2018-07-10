package com.lirong.write;

import com.lirong.domian.DataInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiRong
 */
public class WriteFileMonitorImpl implements WriteFileMonitor {


    private static Integer strategy =0;

//    private static Map<Integer,List<String>> saveFileInfo=new HashMap<>();
//
//    private static Integer y =1;


    private static List<String> list =new ArrayList<>();

    @Override
    public void write(List<DataInfo> infos) {

        try {
            try(BufferedWriter bw =new BufferedWriter(new FileWriter(GenerateStrategy.preMerge(strategy)))){

                infos.forEach( info-> {
                    try {
                        bw.write(info.Obj2Str());
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                list.add(GenerateStrategy.preMerge(strategy));
                strategy++;

                System.out.println(list.size());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<String> call() {

        return list;
    }


}
