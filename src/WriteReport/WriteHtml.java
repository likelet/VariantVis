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
        try {
            builder.append("<!DOCTYPE HTML>\n<html>\n");

            //header HTML
            try {
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/Highcharts.js"));
                builder.append("<meta charset=\"utf-8\">\n");
                StringBuilder headBuilder = new StringBuilder();
                headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/jquery.js"));
//            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/js/jquery-ui.min.js"));
                headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/js/bootstrap.min.js"));
                headBuilder.append(ReadlibAndWrite.WriteCSS("src/resources/css/bootstrap.min.css"));
//highchart
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/highcharts.js"));
//          headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/jspdf.js"));
//          headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/canvg.js"));
            headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/exporting.js"));
//          headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/export-csv.js"));
//          headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/highcharts-export-clientside.js"));
//          headBuilder.append(ReadlibAndWrite.WriteJS("src/resources/exportModule/exporting-offline.js"));

//sidebar
                headBuilder.append(ReadlibAndWrite.WriteCSS("src/resources/css/simple-sidebar.css"));

            headBuilder.append(ReadlibAndWrite.writeSrc(StringCoverter.addFunctionString(new PiechartFunctionstring("container1").getOutstr()), "javascript"));
            headBuilder.append(ReadlibAndWrite.writeSrc(StringCoverter.addFunctionString(new SingleClassLinechartFunctionstring("container2").getOutstr()), "javascript"));
//sidebar
                builder.append(new HeaderString(headBuilder).getBuilder()).append("\n");

            } catch (IOException ex) {
                Logger.getLogger(WriteHtml.class.getName()).log(Level.SEVERE, null, ex);
            }
            //body html
            StringBuilder bodyBuilder = new StringBuilder();
            bodyBuilder.append(
                    StringCoverter.tags_id("div", "wrapper",
                            StringCoverter.tags_id("nav", "sidebar-wrapper",
                                    StringCoverter.tags_class("ul", "sidebar-nav",
                                            StringCoverter.tags_class("li", "sidebar-brand", "Content") + "\n"
                                            + StringCoverter.tags("li", StringCoverter.tags_href("a", "#container1", "test")) + "\n"
                                            + StringCoverter.tags("li", StringCoverter.tags_href("a", "#container2", "test2"))
                                    )
                            ) + "\n"
                            + StringCoverter.tags_id("div", "page-content-wrapper",
                                    StringCoverter.tags_id_class("a", "menu-toggle", "btn btn-default", "menu")
                                                            + StringCoverter.tags_id_style("div", "container1", "min-width:400px;height:400px;", "")
                                                            + StringCoverter.tags_id_style("div", "container2", "min-width:400px;height:400px;", "")
                            )
                    ) + "\n"
                    + ReadlibAndWrite.writeSrc(this.sidebarJS(), "javascript")
            );

            builder.append(new BodyString(bodyBuilder).getBuilder() + "\n");
            builder.append("</html>\n");
        } catch (IOException ex) {
            Logger.getLogger(WriteHtml.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public String sidebarJS() {
        String str = " $(\"#menu-toggle\").click(function(e) {\n"
                + "        e.preventDefault();\n"
                + "        $(\"#wrapper\").toggleClass(\"toggled\");\n"
                + "    });";
        return str;
    }

    public static void openExplorer(String url) {
        if (java.awt.Desktop.isDesktopSupported()) {
            try {
                //创建一个URI实例,注意不是URL
                java.net.URI uri = java.net.URI.create(url);
                //获取当前系统桌面扩展
                java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            } catch (java.lang.NullPointerException e) {
                //此为uri为空时抛出异常
            } catch (java.io.IOException e) {
                //此为无法获取系统默认浏览器
            }
        }
    }

    public static void openExplorerLocalFile(String filename) {
        if (java.awt.Desktop.isDesktopSupported()) {
            try {
                //创建一个URI实例,注意不是URL
                java.net.URI uri = java.net.URI.create("file://" + new File(filename).getAbsolutePath());
                //获取当前系统桌面扩展
                java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            } catch (java.lang.NullPointerException e) {
                //此为uri为空时抛出异常
            } catch (java.io.IOException e) {
                //此为无法获取系统默认浏览器
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(StringCoverter.tags_id_style("div","container1", "min-width:400px;height:400px;", ""));
        new WriteHtml("test.html");
//        WriteHtml.openExplorer("file:///"+new File("test.html").getAbsolutePath().replace("\\", "/"));
        WriteHtml.openExplorer("file://" + new File("test.html").getAbsolutePath());
    }
}
