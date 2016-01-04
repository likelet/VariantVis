/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WriteReport;

import Tools.ReadlibAndWrite;
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
        builder.append("<html lang=\"en\">\n");
        builder.append("<meta charset=\"utf-8\">\n");
        //header HTML
        StringBuilder headBuilder = new StringBuilder();
        try {
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/Highcharts.js"));
            headBuilder.append(ReadlibAndWrite.writeLink("http://code.highcharts.com/modules/exporting.js", "javascript"));
            headBuilder.append(ReadlibAndWrite.writeLink("https://code.highcharts.com/highcharts.js", "javascript"));
            headBuilder.append(ReadlibAndWrite.writeLink("http://www.highcharts.com/lib/jquery-1.11.0.min.js", "javascript"));
            headBuilder.append(ReadlibAndWrite.writeSrc(this.teststr()));
            builder.append(new HeaderString(headBuilder).getBuilder()).append("\n");
        } catch (IOException ex) {
            Logger.getLogger(WriteHtml.class.getName()).log(Level.SEVERE, null, ex);
        }
        //body html
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<div id=\"container\" style=\"min-width:800px;height:400px;\"></div>\n");
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
        new WriteHtml("G:\\data\\weilai\\test.html");
    }
}
