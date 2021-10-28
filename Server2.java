import java.net.*;
import java.io.*;
class Server2{
    public static void main(String args[])throws Exception{
        ServerSocket ss=new ServerSocket(3333); //Créer la socket de server (accueil)
        Socket s=ss.accept(); //Permet d'attendre la connexion, et l'accepte ensuite
        DataInputStream din=new DataInputStream(s.getInputStream()); //Lance le flux d'input
        DataOutputStream dout=new DataOutputStream(s.getOutputStream()); //Lance le flux de retour
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //sert à lire l'Input Stream

        String str="",str2="";
        while(!str.equals("stop")){
            str=din.readUTF(); //Attend une entrée sur le flux d'input
            System.out.println("Martin says: "+str);
            str2=br.readLine(); //lit l'entrée sur le terminal
            dout.writeUTF(str2); //Ecrit dans flux sortant
            dout.flush(); //Envoie
        }
        din.close();
        s.close();
        ss.close();
    }}