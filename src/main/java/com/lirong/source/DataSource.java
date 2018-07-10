package com.lirong.source;

import com.lirong.obtain.Package;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 数据源头
 * @author LiRong
 */
public class DataSource {

    private static final Logger LOG = LoggerFactory.getLogger(DataSource.class);

    private String filePath;

    public DataSource(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void outputData(Package bao, String filePath){
        File file =new File(filePath);
        if(!file.exists() || !file.isFile()){
            LOG.error("File does not exist or not file");
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){

            String line;
            while((line = reader.readLine())!=null){
                bao.ret(line);
            }
        } catch (IOException e) {
            LOG.error("read file error:",e);
        }

    }
}
