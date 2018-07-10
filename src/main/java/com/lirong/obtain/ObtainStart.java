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

    public ObtainStart(String fmt) {
        this.fmt = fmt;
    }

    @Override
    public void obtain(DataSource dataSource) {
        dataSource.outputData(s -> {
            String[] split = s.split(fmt);
            DataInfo dataInfo = new DataInfo(split[0], split[1]);
            transfer(dataInfo);
        },dataSource.getFilePath());

        this.stop();
    }

    @Override
    public void stop() {

        LOG.info("obtain data end");
        WriteFileMonitor writeFileMonitor = new WriteFileMonitorImpl();
        List<String> list = writeFileMonitor.call();
        Dispatch dispatch = new Dispatch();
        dispatch.dispatch(list);
        dispatch.canMeger();
    }


    @Override
    public void transfer(DataInfo dataInfo) {
        dataInfoList.add(dataInfo);
        Collections.sort(dataInfoList);
        WriteFileMonitor writeFileMonitor;
        if(dataInfoList.size()==3){
            writeFileMonitor = new WriteFileMonitorImpl();
            writeFileMonitor.write(dataInfoList);
            dataInfoList.clear();
        }
        if(READ_OVER){
            if(dataInfoList.size()!=0) {
                writeFileMonitor = new WriteFileMonitorImpl();
                writeFileMonitor.write(dataInfoList);
            }else {
                writeFileMonitor = new WriteFileMonitorImpl();
                writeFileMonitor.write(new ArrayList<>());
            }

        }
    }


    public static void main(String[] args) {

        DataSource source = new DataSource("F:\\test\\test.txt");

        ObtainStart start = new ObtainStart("-");

        start.obtain(source);
    }

}
