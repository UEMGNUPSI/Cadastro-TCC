/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author NUPSI
 */
public class Cliente{
    
    
    public static void main (String[]args)throws UnknownHostException,IOException{
    Socket cliente = new Socket("192.168.0.104",1234);

    
        ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
        FileInputStream file = new FileInputStream("c:/oi/01.png");
        byte[] buf = new byte[4096];
        while(true){
            int len = file.read(buf);
            if(len == -1)break;
            out.write(buf,0,len);
        }
    }
}
