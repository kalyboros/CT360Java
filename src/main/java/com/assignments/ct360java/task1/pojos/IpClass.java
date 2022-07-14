package com.assignments.ct360java.task1.pojos;
import com.assignments.ct360java.task1.exceptions.IpSyntaxException;

import java.util.regex.*;
public class IpClass {
    private String ip;

    public IpClass(String ip) throws IpSyntaxException {

        if (!isValidIPAddress(ip)){
            throw new IpSyntaxException(ip);
        }
        this.ip = ip;
    }

    //here we validate ip address syntax
    public static boolean isValidIPAddress(String ip) {
        String zeroTo255
                = "(\\d{1,2}|(0|1)\\"
                + "d{2}|2[0-4]\\d|25[0-5])";
        String regex
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;


        Pattern p = Pattern.compile(regex);

        if (ip == null) {
            return false;
        }

        Matcher m = p.matcher(ip);

        return m.matches();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
