/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WriteReport;

import Tools.PiechartFunctionstring;
import Tools.ReadlibAndWrite;
import Tools.SingleClassLinechartFunctionstring;
import Tools.StringCoverter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * WriteHtml</p>
 * <p>
 * Created on 2016-1-4 14:23:07</p>
 * <p>
 * Author Email: zhaoqi3@mail2.sysu.edu.cn</p>
 *
 * @author ZHAO Qi
 * @date 2016-1-4 14:23:07
 * @version java 1.6.0
 * @version
 */
public class WriteHtml {

    StringBuilder builder = new StringBuilder();
    private String outFilename;

    public WriteHtml() {
    }

    public WriteHtml(String outFilename) {
        this.outFilename = outFilename;
        this.process();
        print();
    }

    public void process() {
        builder.append("<!DOCTYPE HTML>\n<html>\n");

        //header HTML
        try {
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/Highcharts.js"));
            builder.append("<meta charset=\"utf-8\">\n");
            StringBuilder headBuilder = new StringBuilder();
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/jquery.js"));
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/highcharts.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/jspdf.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/canvg.js"));
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/exporting.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/export-csv.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/highcharts-export-clientside.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/exporting-offline.js"));
            headBuilder.append(ReadlibAndWrite.writeSrc(StringCoverter.addFunctionString(new PiechartFunctionstring("container1").getOutstr()),"javascript"));
            headBuilder.append(ReadlibAndWrite.writeSrc(StringCoverter.addFunctionString(new SingleClassLinechartFunctionstring("container2").getOutstr()),"javascript"));
            
            builder.append(new HeaderString(headBuilder).getBuilder()).append("\n");

        } catch (IOException ex) {
            Logger.getLogger(WriteHtml.class.getName()).log(Level.SEVERE, null, ex);
        }
        //body html
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<div id=\"container1\" style=\"min-width:400px;height:400px;\"></div>\n");
        bodyBuilder.append("<div id=\"container2\" style=\"min-width:400px;height:400px;\"></div>\n");
        builder.append(new BodyString(bodyBuilder).getBuilder() + "\n");
        builder.append("</html>\n");
    }

    public void print() {
        try {
            FileWriter fw = new FileWriter(outFilename);
            fw.append(builder.toString());
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteHtml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String teststr() {
        String str = "$(function () { \n"
                + "	    $('#container').highcharts({\n"
                + "	        chart: {\n"
                + "	            type: 'column'\n"
                + "	        },\n"
                + "	        title: {\n"
                + "	            text: 'My first Highcharts chart'\n"
                + "	        },\n"
                + "	        xAxis: {\n"
                + "	            categories: ['my', 'first', 'chart']\n"
                + "	        },\n"
                + "	        yAxis: {\n"
                + "	            title: {\n"
                + "	                text: 'something'\n"
                + "	            }\n"
                + "	        },\n"
                + "	        series: [{\n"
                + "	            name: 'Jane',\n"
                + "	            data: [1, 0, 4]\n"
                + "	        }, {\n"
                + "	            name: 'John',\n"
                + "	            data: [5, 7, 3]\n"
                + "	        }]\n"
                + "	    });\n"
                + "	});";

        return str;
    }

    public static void main(String[] args) {
        new WriteHtml("test.html");
    }
}
