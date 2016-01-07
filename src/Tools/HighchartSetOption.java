/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

/**
 * <p>HighchartSetOption</p>
 * <p>Created on 2016-1-7 10:52:46</p>
 * <p>Author Email: zhaoqi3@mail2.sysu.edu.cn</p>
 * @author ZHAO Qi
 * @date 2016-1-7 10:52:46
 * @version java 1.6.0
 * @version 
 */
public class HighchartSetOption {

    public static String getOptionStr(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Highcharts.setOptions({").append(str).append("});");
        return sb.toString();
    }
}
