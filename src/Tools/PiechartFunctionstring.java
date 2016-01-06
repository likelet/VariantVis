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

    public PiechartFunctionstring(){
        LinkedHashMap<String, String> dataset=new LinkedHashMap<String, String> ();
        dataset.put("test1", "50");
        dataset.put("test2", "30");
        dataset.put("test3", "20");
        this.dataset=dataset;
        this.classid="container";
        this.getPieChartFunctionString();
        
    }
    public PiechartFunctionstring(String classid, LinkedHashMap<String, String> dataset) {
        this.classid = classid;
        this.dataset = dataset;
        this.getPieChartFunctionString();
    }

    public void getPieChartFunctionString() {
        StringBuilder sb = new StringBuilder();
        sb.append("$('#").append(this.classid).append("').highcharts({");
        String chartstr 
                = StringCoverter.getKeyvauleString("plotBackgroundColor", "white") + ","
                + StringCoverter.getKeyvauleString("plotBorderWidth", "null") + ","
                + StringCoverter.getKeyvauleString("plotShadow", "false");
        String titlestr 
                = StringCoverter.getKeyvauleString("text", "Browser market shares at a specific website, 2010");
        String tooltipstr 
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
            tempseriesstr+=StringCoverter.getContainSeriesElement(key,dataset.get(key))+",";
        }
        tempseriesstr=tempseriesstr.substring(0,tempseriesstr.length()-1);
        seriesstr+=StringCoverter.getDataStr(tempseriesstr);
                        
              
        sb.append(StringCoverter.getContains("chart", chartstr)).
                append(",").
                append(StringCoverter.getContains("title", titlestr)).
                append(",").
                append(StringCoverter.getContains("tooltip", tooltipstr)).
                append(",").
                append(StringCoverter.getContains("plotOptions", plotOptionsstr)).
                append(",").
                append(StringCoverter.getContainSeries(seriesstr)).append("});");
        outstr=sb.toString();

    }

    //get out
    public String getOutstr() {
        return outstr;
    }
    
    public static void main(String[] args) {
        LinkedHashMap<String, String> dataset=new LinkedHashMap<String, String> ();
        dataset.put("test1", "10");
        dataset.put("test2", "11");
        dataset.put("test3", "10");

        PiechartFunctionstring ps=new PiechartFunctionstring("certainid",dataset);
        System.out.println(ps.getOutstr());
        
    }
}
