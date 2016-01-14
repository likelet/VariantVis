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
import java.io.File;
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
            builder.append("<meta name=\"viewport\" content=\"width=device-width,minimum-scale=1\">");
            StringBuilder headBuilder = new StringBuilder();
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/jquery.js"));
            
            //highchart
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/highcharts.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/jspdf.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/canvg.js"));
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/exporting.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/export-csv.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/highcharts-export-clientside.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/exporting-offline.js"));
            headBuilder.append(ReadlibAndWrite.writeSrc(StringCoverter.addFunctionString(new PiechartFunctionstring("container1").getOutstr()),"javascript"));
            headBuilder.append(ReadlibAndWrite.writeSrc(StringCoverter.addFunctionString(new SingleClassLinechartFunctionstring("container2").getOutstr()),"javascript"));
            
            //sidebar
            headBuilder.append(ReadlibAndWrite.WriteCSS("src/resources/css/sidebar/jquery.sidr.light.min.css"));
            headBuilder.append(ReadlibAndWrite.WriteCSS("src/resources/css/sefdefine.css"));
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/js/sidebar/jquery.sidr.min.js"));
            headBuilder.append(ReadlibAndWrite.writeSrc(this.sidebarJS(), "javascript"));
            
            builder.append(new HeaderString(headBuilder).getBuilder()).append("\n");

        } catch (IOException ex) {
            Logger.getLogger(WriteHtml.class.getName()).log(Level.SEVERE, null, ex);
        }
        //body html
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append(
                StringCoverter.tags_id("div", "mobile-header",
                        StringCoverter.tags_id_href("a", "responsive-menu-button", "#sidr-main", "Menu") 
                ) + "\n"
                + StringCoverter.tags("div",
                        StringCoverter.tags_id_style("div", "container1", "min-width:400px;height:400px;", "")
                        + StringCoverter.tags_id_style("div", "container2", "min-width:400px;height:400px;", "")
                ) + "\n"
                +StringCoverter.tags_id("div", "navigation",
                        StringCoverter.tags_class("nav", "nav",
                                StringCoverter.tags("ul",
                                        StringCoverter.tags("li", StringCoverter.tags_href("a", "#container1", "test")) + "\n"
                                        + StringCoverter.tags("li", StringCoverter.tags_href("a", "#container2", "test2"))
                                )
                        )
                )
        );

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

    public String sidebarJS() {
        String str = " $('#responsive-menu-button').sidr({\n"
                + "      name: 'sidr-main',\n"
                + "      source: '#navigation'\n"
                + "    });";
        return str;
    }

    public static void openExplorer(String url){
            if(java.awt.Desktop.isDesktopSupported()){
            try{
                //创建一个URI实例,注意不是URL
                java.net.URI uri=java.net.URI.create(url);
                //获取当前系统桌面扩展
                java.awt.Desktop dp=java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            }catch(java.lang.NullPointerException e){
                //此为uri为空时抛出异常
            }catch(java.io.IOException e){
                //此为无法获取系统默认浏览器
            }
        }
    }
     public static void openExplorerLocalFile(String filename){
            if(java.awt.Desktop.isDesktopSupported()){
            try{
                //创建一个URI实例,注意不是URL
                java.net.URI uri=java.net.URI.create("file://"+new File(filename).getAbsolutePath());
                //获取当前系统桌面扩展
                java.awt.Desktop dp=java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            }catch(java.lang.NullPointerException e){
                //此为uri为空时抛出异常
            }catch(java.io.IOException e){
                //此为无法获取系统默认浏览器
            }
        }
    }
    public static void main(String[] args) {
//        System.out.println(StringCoverter.tags_id_style("div","container1", "min-width:400px;height:400px;", ""));
        new WriteHtml("test.html");
        WriteHtml.openExplorer("file:///"+new File("test.html").getAbsolutePath().replace("\\", "/"));
    }
}
