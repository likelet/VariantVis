/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WriteReport;

/**
 *
 * @author Zinky-i7
 */
public class HeaderString {

    StringBuilder builder = new StringBuilder();

    public HeaderString(StringBuilder str) {
        builder.append("<head>\r\n");
        builder.append(str.toString());
        builder.append("</head>\r\n");
    }

    public StringBuilder getBuilder() {
        return builder;
    }

}
