/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WriteReport;

/**
 * <p>
 * BodyString</p>
 * <p>
 * Created on 2016-1-4 10:40:30</p>
 * <p>
 * Author Email: zhaoqi3@mail2.sysu.edu.cn</p>
 *
 * @author ZHAO Qi
 * @date 2016-1-4 10:40:30
 * @version java 1.6.0
 * @version
 */
public class BodyString {

    StringBuilder builder = new StringBuilder();

    public BodyString(StringBuilder str) {
        builder.append("<body>\r\n");
        builder.append(str.toString());
        builder.append("</body>\r\n");
    }

    public StringBuilder getBuilder() {
        return builder;
    }

}
