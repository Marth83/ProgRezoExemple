import java.net.*;
import java.io.*;
class Client2{
    public static void main(String args[])throws Exception{
        Socket s=new Socket("localhost",3333);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="",str2="";
        while(!str.equals("stop")){
            str=br.readLine(); //Lit le terminal jusqu'à \n
            dout.writeUTF(str); //Met le texte dans le flux
            dout.flush(); //Envoie le flux
            str2=din.readUTF(); //Lis la réponse (met en pause le prog)
            System.out.println("Server says: "+str2);
        }

        dout.close();
        s.close();
    }}
