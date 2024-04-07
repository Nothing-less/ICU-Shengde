package icu.nothingless.ysd;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String pathname = System.getProperty("user.name");
        File f = new File(pathname + ".txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
            os.write(getInfo().getBytes(StandardCharsets.UTF_8));
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("运行结束");
    }

    public static String getInfo() {
        InetAddress addr;
        StringBuilder sb = new StringBuilder();
        try {
            addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress().toString();
            String hostName = addr.getHostName().toString();
            sb.append("本机IP：").append(ip).append("\n本机名称:").append(hostName);
        } catch (UnknownHostException e) {
            sb.append("UnknownHost");
        }
        return sb.toString();
    }
}
