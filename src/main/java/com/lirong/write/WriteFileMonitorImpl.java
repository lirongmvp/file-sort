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

    //生成文件的规则
    private static Integer strategy =0;

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
