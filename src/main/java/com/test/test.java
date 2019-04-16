package com.test;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStream;

public class test {

    public static void main(String[] args){
        Session session = null;


        try{
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session=jsch.getSession("ethan.qiu", "dhcp-10-182-172-245.cn.oracle.com", 22);
            session.setPassword("Qiu522sun@ouc");
            session.setConfig(config);
            session.connect(5000);
        }catch(Exception e){
            e.printStackTrace();
        }

        int timeout = 10000;
        String command = "docker ps -a";
        StringBuilder output = new StringBuilder();
        try{
            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in=channel.getInputStream();
            channel.connect(timeout);
            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    output.append(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        session.disconnect();
        System.out.println(output.toString());
    }
}
