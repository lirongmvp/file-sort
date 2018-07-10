package com.lirong.domian;

/**
 * 数据转换
 * Created by lirong on 2018/7/9.
 */
public interface DataFormat<T> {

    T str2Obj(String s);

    String Obj2Str();

}
