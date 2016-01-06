/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.LinkedHashMap;

/**
 *
 * @author zhaoqi
 */
public class PiechartFunctionstring extends FigureClass {

    private String classid;
    private LinkedHashMap<String, String> dataset;
    private String outstr;

    public PiechartFunctionstring(String classid, LinkedHashMap<String, String> dataset) {
        this.classid = classid;
        this.dataset = dataset;
    }

    public void getPieChartFunctionString(String containid, LinkedHashMap<String, Double> piedataset) {
        StringBuilder sb = new StringBuilder();
        sb.append("  $('#" + this.classid + "').highcharts({\n");
        String chartstr 
                = StringCoverter.getKeyvauleString("plotBackgroundColor", "null") + ","
                + StringCoverter.getKeyvauleString("plotBorderWidth", "null") + ","
                + StringCoverter.getKeyvauleString("plotShadow", "false");
        String titlestr 
                = StringCoverter.getKeyvauleString("text", "Browser market shares at a specific website, 2010");
        String toottipstr 
                = StringCoverter.getKeyvauleString("pointFormat", "{series.name}: <b>{point.percentage:.1f}%</b>");
        String plotOptionsstr
                = StringCoverter.getContains("pie",
                        StringCoverter.getKeyvauleString("allowPointSelect", "true") + ","
                        + StringCoverter.getKeyvauleString("cursor", "pointer") + ","
                        + StringCoverter.getContains("dataLabels",
                                StringCoverter.getKeyvauleString("enabled", "true") + ","
                                + StringCoverter.getKeyvauleString("color", "#000000") + ","
                                + StringCoverter.getKeyvauleString("connectorColor", "#000000") + ","
                                + StringCoverter.getKeyvauleString("format", "<b>{point.name}</b>: {point.percentage:.1f} %")
                        )
                );
        //series
        String seriesstr
                =StringCoverter.getKeyvauleString("type","pie")+","+
                 StringCoverter.getKeyvauleString("name","test2")+",";
        String tempseriesstr="";
        for (String key:dataset.keySet()) {
            seriesstr+=StringCoverter.getKeyvauleString(key,dataset.get(key))+",";
        }
        tempseriesstr=tempseriesstr.substring(0,tempseriesstr.length()-1);
        seriesstr+=StringCoverter.getDataStr(tempseriesstr);
                        
              
        sb.append(StringCoverter.getContains("chart", chartstr)+","+
                StringCoverter.getContains("title", titlestr)+","+
                StringCoverter.getContains("toottip", toottipstr)+","+
                StringCoverter.getContains("plotOptions", plotOptionsstr)+","+
                StringCoverter.getContainSeries(seriesstr)
                );
        outstr=sb.toString();

    }
}
