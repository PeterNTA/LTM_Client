/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client;
import java.io.*;
import java.net.Socket;
/**
 *
 * @author peter
 */
public class Client {
     public String connection(String text) throws Exception
    {
        String sentence_to_server;
        String sentence_from_server;
    
        //Tạo Inputstream(từ bàn phím)
        // System.out.print("Input from client: ");
        BufferedReader inFromUser =
            new BufferedReader(new StringReader(text));
        //Lấy chuỗi ký tự nhập từ bàn phím
        sentence_to_server = inFromUser.readLine();
//    
        //Tạo socket cho client kết nối đến server qua ID address và port number
        Socket clientSocket = new Socket("localhost", 6543);
    
        //Tạo OutputStream nối với Socket
        DataOutputStream outToServer =
            new DataOutputStream(clientSocket.getOutputStream());
    
        //Tạo inputStream nối với Socket
        BufferedReader inFromServer =
            new BufferedReader(new
            InputStreamReader(clientSocket.getInputStream()));
//     
        //Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket (ở trên)
        outToServer.writeBytes(sentence_to_server + '\n');
    
        //Đọc tin từ Server thông qua InputSteam đã nối với socket
        sentence_from_server = inFromServer.readLine();
    
        //print kết qua ra màn hình
//        System.out.println("FROM SERVER: " + sentence_from_server);
        
    
        //Đóng liên kết socket
//        clientSocket.close();    
        return sentence_from_server;
    } 

}
