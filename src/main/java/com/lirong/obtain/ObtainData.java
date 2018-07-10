package com.lirong.obtain;

import com.lirong.domian.DataInfo;
import com.lirong.source.DataSource;

/**
 * 获取数据接口
 * Created by lirong on 2018/7/9.
 */
public interface ObtainData {

    /**
     * 获取数据
     */
    void obtain(DataSource dataSource);

    /**
     * 停止数据
     */
    void stop();

    /**
     * 传输数据
     * @return List<DataInfo>
     */
    void transfer(DataInfo dataInfo);
}
