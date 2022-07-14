package com.assignments.ct360java.task1.exceptions;

public class IpSyntaxException extends Exception {
    private String ip;

    public IpSyntaxException(String ip){
        super("Wrong IP syntax! It is: " + ip + "But it should be XXX.XXX.XXX.XXX");
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
