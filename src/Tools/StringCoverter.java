/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

/**
 * <p>StringCoverter</p>
 * <p>Created on 2016-1-6 18:12:30</p>
 * <p>Author Email: zhaoqi3@mail2.sysu.edu.cn</p>
 * @author ZHAO Qi
 * @date 2016-1-6 18:12:30
 * @version java 1.6.0
 * @version 
 */
public class StringCoverter {

    public static String getKeyvauleString(String key, String value) {
        return key + ": \'" + value + "\'";
    }
    public static String getKeyvalueDouble(String key, Double value) {
        return key + ": '" + value + "'";
    }
    public static String getDataList(Object[] datalist){
        String str="";
        for (int i = 0; i < datalist.length; i++) {
            str+=datalist[i]+",";
        }
        str=str.substring(0,str.length()-1);
        return "data: [" +str+"]";
    }
    public static String getDataStr(String str){
        return "data: [" +str+"]";
    }
    public static String getContains(String key,String str){
        return key+": {" +str+"}";
    }
    public static String getContainSeries(String str){
        return "series: {" +str+"}";
    }
    public static String getContainSeriesElement(String str,String str2){
        return "['" +str+"',"+str2+"]";
    }
    //return series
    public static String getKeyvalueData(String key,Object[] datalist) {
        return "{"+StringCoverter.getKeyvauleString("name", key)+","+StringCoverter.getDataList(datalist);
    }
    //return function str
    public static String addExternalString(String str){
        return "$(function () {"+str+"});";
    }
    public static void main(String[] args) {
        System.out.println(StringCoverter.getContainSeriesElement("test","1"));
    }
}
