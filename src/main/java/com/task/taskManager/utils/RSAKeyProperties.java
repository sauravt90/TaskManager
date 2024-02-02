package com.task.taskManager.utils;

import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
public class RSAKeyProperties {


   private RSAPublicKey publicKey;
   private RSAPrivateKey privateKey;


   public RSAKeyProperties(){
       KeyPair keyPair = KeyGeneratorUtility.generateRsaKey();
       this.privateKey= (RSAPrivateKey) keyPair.getPrivate();
       this.publicKey = (RSAPublicKey) keyPair.getPublic();
   }

   public RSAPublicKey getPublicKey(){
       return this.publicKey;
   }

   public void setPrivateKey(RSAPrivateKey privateKey){
         this.privateKey = privateKey;
   }

    public void setPublicKey(RSAPublicKey publicKey){
        this.publicKey = publicKey;
    }

    public RSAPrivateKey getPrivateKey(){
        return  this.privateKey;
    }

}
