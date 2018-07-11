package com.lirong.domian;

/**
 * Created by lirong on 2018/7/9.
 */
public class DataInfo implements Comparable,DataFormat<DataInfo> {

    private String dataKey;

    private String dataValue;

    private static String sign;

    public DataInfo(String dataKey, String dataValue) {
        this.dataKey = dataKey;
        this.dataValue = dataValue;
    }

    public static String getSign() {
        return sign;
    }

    public static void setSign(String sign) {
        DataInfo.sign = sign;
    }

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "DataInfo{" +
                "dataKey='" + dataKey + '\'' +
                ", dataValue='" + dataValue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataInfo dataInfo = (DataInfo) o;

        if (dataKey != null ? !dataKey.equals(dataInfo.dataKey) : dataInfo.dataKey != null) return false;
        return dataValue != null ? dataValue.equals(dataInfo.dataValue) : dataInfo.dataValue == null;
    }

    @Override
    public int hashCode() {
        int result = dataKey != null ? dataKey.hashCode() : 0;
        result = 31 * result + (dataValue != null ? dataValue.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object data) {

        DataInfo dataInfo = (DataInfo)data;

        int i = dataInfo.getDataKey().compareTo(this.getDataKey());
        if(i>0){
            return -1;
        }
        if(i<0){
            return 1;
        }

        return 0;
    }


    @Override
    public DataInfo str2Obj(String s) {
        return null;
    }

    @Override
    public String Obj2Str() {

        return this.getDataKey()+sign+this.getDataValue();
    }
}
