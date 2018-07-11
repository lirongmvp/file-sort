package com.lirong.merge;

import com.lirong.write.GenerateStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * @author LiRong
 */
@SuppressWarnings("all")
public class FileMergeTriggerImpl implements FileMergeTrigger {

    private static final Logger LOG = LoggerFactory.getLogger(FileMergeTrigger.class);

    private static Integer x = 0;

    @Override
    public String merge(List<String> fileList) {


        try {
            if(fileList.size()==1){
                LOG.info("merge file success");
                System.out.println("merge file success");
                return "OK";
            }
            List<String> list = new ArrayList();

            int i;
            for (i = 0; i <= (fileList.size() - 2); i += 2) {
                String path = hebing(fileList.get(i), fileList.get(i + 1), x);
                list.add(path);
                x++;
            }
            if(i==(fileList.size()-1)) {
                list.add(fileList.get(fileList.size() - 1));
            }
            return merge(list);
        }catch (Exception e){
            LOG.error("merge file error:",e);
            return "merge file error";
        }

    }



    protected static String hebing(String p1, String p2,Integer x) {
        try {
            try (BufferedReader reader1 = new BufferedReader(new FileReader(p1));
                 BufferedReader reader2 = new BufferedReader(new FileReader(p2));
                BufferedWriter writer =new BufferedWriter(new FileWriter(GenerateStrategy.generatePath(x)))
            ) {
                List<String> list = new ArrayList<>();
                String line1;
                String line2;

                if ((line1 = reader1.readLine()) != null) {
                    list.add(line1);
                }
                if ((line2 = reader2.readLine()) != null) {
                    list.add(line2);
                }

                String path = erheyi(list, line1, line2, reader1, reader2,writer);

                if (path == "0") {
                    return GenerateStrategy.generatePath(x);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static String erheyi(List<String> list, String line1, String line2,
                                 BufferedReader reader1, BufferedReader reader2,BufferedWriter writer1) {
        try {
            if (list == null || list.isEmpty()) {
                return "0";
            }
            Collections.sort(list);
            String s = list.get(0);
            try (BufferedWriter writer = writer1) {
                writer.write(s);
                writer.newLine();
                if (s.equals(line1)) {
                    list.remove(0);
                    if ((line1 = reader1.readLine()) != null) {
                        list.add(line1);
                    }
                } else if (s.equals(line2)) {
                    list.remove(0);
                    if ((line2 = reader2.readLine()) != null) {
                        list.add(line2);
                    }
                }
                return erheyi(list, line1, line2, reader1, reader2,writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "出现错误";
        }
        return null;
    }

}

