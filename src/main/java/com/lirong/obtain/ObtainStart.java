package com.lirong.obtain;

import com.lirong.domian.DataInfo;
import com.lirong.merge.Dispatch;
import com.lirong.source.DataSource;
import com.lirong.write.WriteFileMonitor;
import com.lirong.write.WriteFileMonitorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LiRong
 */
public class ObtainStart implements ObtainData {

    private static final Logger LOG = LoggerFactory.getLogger(DataSource.class);

    /**
     * 数据包
     */
    private List<DataInfo> dataInfoList = new ArrayList<>();
    /**
     * 格式化
     */
    private String fmt;

    private static boolean READ_OVER=false;

    private Integer readNum;

    public ObtainStart(String fmt, Integer readNum) {
        this.fmt = fmt;
        this.readNum = readNum;
    }

    @Override
    public void obtain(DataSource dataSource) {
        dataSource.outputData(s -> {
            String[] split = s.split(fmt);
            DataInfo dataInfo = new DataInfo(split[0], split[1]);
            transfer(dataInfo);
        },dataSource.getFilePath());

        if(dataInfoList.size()>0){
            WriteFileMonitor writeFileMonitor = new WriteFileMonitorImpl();
            writeFileMonitor.write(dataInfoList);
        }
        this.stop();
    }

    @Override
    public void stop() {

        LOG.info("obtain data end");
        WriteFileMonitor writeFileMonitor = new WriteFileMonitorImpl();
        List<String> list = writeFileMonitor.call();
        Dispatch dispatch = new Dispatch();
        dispatch.dispatch(list);
        dispatch.canMerge();
    }


    @Override
    public void transfer(DataInfo dataInfo) {
        dataInfoList.add(dataInfo);
        Collections.sort(dataInfoList);
        WriteFileMonitor writeFileMonitor;
        if(dataInfoList.size()==readNum){
            writeFileMonitor = new WriteFileMonitorImpl();
            writeFileMonitor.write(dataInfoList);
            dataInfoList.clear();
        }

    }


}
