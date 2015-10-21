/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keystorage;

import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author PC
 */
public class KEYSTORAGE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            KeyGenerator kg=KeyGenerator.getInstance("AES");
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG"); //ou ("NativePRNG", "SUN"); - todas as coisas random que existem - entropy
            kg.init(sr);
            SecretKey sk= kg.generateKey();
            KeyStore ks = KeyStore.getInstance("JCEKS");
            ks.load(null,null);
            ks.setKeyEntry("chave boa", sk, "password".toCharArray(), null);
            FileOutputStream writeStream = new FileOutputStream ("novaks.jks");

            ks.store(writeStream, "tambem nao".toCharArray());
            writeStream.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        // TODO code application logic here
    }
    
}
