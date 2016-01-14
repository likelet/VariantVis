/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

import java.util.LinkedHashMap;

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
    //
    public static String getDataList(LinkedHashMap<String,String> datalist){
        String str="";
        for(String key:datalist.keySet()){
            str+=datalist.get(key)+",";
        }
        str=str.substring(0,str.length()-1);
        return "data: [" +str+"]";
    }
    //
    public static String getDataStringList(String name,LinkedHashMap<String,String> datalist){
        String str="";
        for(String key:datalist.keySet()){
            str+="'"+key+"',";
        }
        str=str.substring(0,str.length()-1);
        return name+": [" +str+"]";
    }
    public static String getDataStr(String str){
        return "data: [" +str+"]";
    }
    public static String getContains(String key,String str){
        return key+": {" +str+"}";
    }
    public static String getContainSeries(String str){
        return "series: [{" +str+"}]";
    }
    public static String getContainSeriesElement(String str,String str2){
        return "['" +str+"',"+str2+"]";
    }
    //return series
    public static String getKeyvalueData(String key,Object[] datalist) {
        return "{"+StringCoverter.getKeyvauleString("name", key)+","+StringCoverter.getDataList(datalist);
    }
    //return function str
    public static String addFunctionString(String str){
        return "$(function () {"+str+"});";
    }
    public static void main(String[] args) {
        System.out.println(StringCoverter.getContainSeriesElement("test","1"));
    }
    
    
    //html tags
    public static String tags(String typestr,String textstr){
        return new StringBuilder("<"+typestr+">"+textstr+"</"+typestr+">\n").toString();
    }
     public static String tags_id(String typestr, String idstr, String textstr) {
        return new StringBuilder("<" + typestr + " id=\"" + idstr + "\">" + textstr + "</" + typestr + ">\n").toString();
    }
     public static String tags_href(String typestr, String hrefstr, String textstr) {
        return new StringBuilder("<" + typestr + " href=\"" + hrefstr + "\">" + textstr + "</" + typestr + ">\n").toString();
    }
    
    public static String tags_class(String typestr, String classstr, String textstr) {
        return new StringBuilder("<" + typestr + " class=\"" + classstr + "\">" + textstr + "</" + typestr + ">\n").toString();
    }

    public static String tags_style(String typestr, String stylestr, String textstr) {
        return new StringBuilder("<" + typestr + " style=\"" + stylestr + "\">" + textstr + "</" + typestr + ">\n").toString();
    }

    public static String tags_class_href(String typestr, String classstr, String hrefstr, String textstr) {
        return new StringBuilder("<" + typestr + " class=\"" + classstr + "\" href=\"" + hrefstr + "\">" + textstr + "</" + typestr + ">\n").toString();
    }

    public static String tags_id_style(String typestr, String idstr, String stylestr, String textstr) {
        return new StringBuilder("<" + typestr + " id=\"" + idstr + "\" style=\"" + stylestr + "\">" + textstr + "</" + typestr + ">\n").toString();
    }
     public static String tags_id_class(String typestr, String idstr, String classstr, String textstr) {
        return new StringBuilder("<" + typestr + " id=\"" + idstr + "\" class=\"" + classstr + "\">" + textstr + "</" + typestr + ">\n").toString();
    }
      public static String tags_id_href(String typestr, String idstr, String hrefstr, String textstr) {
        return new StringBuilder("<" + typestr + " id=\"" + idstr + "\" href=\"" + hrefstr + "\">" + textstr + "</" + typestr + ">\n").toString();
    }
}
