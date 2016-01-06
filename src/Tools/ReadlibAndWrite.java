/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Zinky-i7
 */
public class ReadlibAndWrite {

    //wright external js
    public static String WriteJS(String jsfile) throws IOException {
        //src\\resources\\Highcharts.js
         StringBuilder builder = new StringBuilder();
        builder.append("<script type=\"text/javascript\">\n");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(jsfile)));
            //FileWriter fw = new FileWriter(outputFile);

            while (br.ready()) {
                builder.append(br.readLine().trim()+"\n");
            }
            //fw.flush();
            br.close();
        } catch (FileNotFoundException ex) {

        }
        builder.append("\n</script>\n");
        return builder.toString();
    }

    //write external css
    public static String WriteCSS(String cssfile) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("<script type=\"text/css\">\n");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(cssfile)));
            //FileWriter fw = new FileWriter(outputFile);

            while (br.ready()) {
                builder.append(br.readLine().trim());
            }
            //fw.flush();
            br.close();
        } catch (FileNotFoundException ex) {

        }
        builder.append("\n</script>\n");
        return builder.toString();
    }
    
    public static String writeLink(String link,String type) throws IOException{
        StringBuilder builder = new StringBuilder();
        builder.append("<script src=\""+link+"\" type=\"text/"+type+"\"></script>\n");
        
        return builder.toString();
    }
    public static String writeSrc(String srccode,String type) throws IOException{
        StringBuilder builder = new StringBuilder();
        builder.append("<script type=\"text/"+type+"\">\n"+srccode+"</script>\n");
        
        return builder.toString();
    }
    
}
