package com.lirong.write;

import com.lirong.domian.DataInfo;

import java.util.List;

/**
 * 写文件监听器
 * Created by lirong on 2018/7/9.
 */
public interface WriteFileMonitor {

    void write(List<DataInfo> infos);

    List<String> call();


}
