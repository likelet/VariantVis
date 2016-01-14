/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

import java.util.LinkedHashMap;

/**
 * <p>SingleClassLinechartFunctionstring</p>
 * <p>Created on 2016-1-7 11:01:34</p>
 * <p>Author Email: zhaoqi3@mail2.sysu.edu.cn</p>
 * @author ZHAO Qi
 * @date 2016-1-7 11:01:34
 * @version java 1.6.0
 * @version
 */
public class SingleClassLinechartFunctionstring extends FigureClass {

    private String classid;
    private LinkedHashMap<String, String> dataset;
    private String outstr;

    public SingleClassLinechartFunctionstring(String classid) {
        LinkedHashMap<String, String> dataset = new LinkedHashMap<String, String>();
        dataset.put("test1", "50");
        dataset.put("test2", "30");
        dataset.put("test3", "20");
        this.dataset=dataset;
        this.classid=classid;
        this.setTitle("Distribution of SNVs");
        this.getSingleClassLinechartFunctionstring();
        
    }
    public SingleClassLinechartFunctionstring(String classid, LinkedHashMap<String, String> dataset) {
        this.classid = classid;
        this.dataset = dataset;
        this.getSingleClassLinechartFunctionstring();
    }

    public void getSingleClassLinechartFunctionstring(){
        StringBuilder sb = new StringBuilder();
        sb.append("$('#").append(this.classid).append("').highcharts({");
        String chartstr="";
//                = StringCoverter.getKeyvauleString("plotBackgroundColor", "white") + ","
//                + StringCoverter.getKeyvauleString("plotBorderWidth", "null") + ","
////                + StringCoverter.getKeyvauleString("selectionMarkerFill", "rgba(0,0,0, 0.2)") + ","
//                + StringCoverter.getKeyvauleString("plotShadow", "false");
        String titlestr 
                = StringCoverter.getKeyvauleString("text", this.getTitle());

        
        
        String xaxisstr=StringCoverter.getDataStringList("categories", dataset);
        
        String seriesstr=StringCoverter.getDataList(dataset);
                        
              
        sb.append(StringCoverter.getContains("chart", chartstr)).
                append(",").
                append(StringCoverter.getContains("title", titlestr)).
                append(",").
                append(StringCoverter.getContains("xAxis", xaxisstr)).
                append(",").
//                append(StringCoverter.getContains("plotOptions", plotOptionsstr)).
//                append(",").
                append(StringCoverter.getContainSeries(seriesstr)).append("});");
        outstr=sb.toString();
    }

    public String getClassid() {
        return classid;
    }

    public LinkedHashMap<String, String> getDataset() {
        return dataset;
    }

    public String getOutstr() {
        return outstr;
    }

    
}
