package com.digito.unico.service;

import com.digito.unico.exceptions.DataBaseOperationException;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class EncryptionService {
    public static final String ALGORITHM = "RSA";

    public String encrypt(String data, String publicKeyText) {
        byte[] cipherText = null;

        PublicKey publicKey = getPublicKey(publicKeyText);

        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipherText = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new DataBaseOperationException("An error occurred while running encryption.");
        }
    }

    private PublicKey getPublicKey(String pub) {

        byte[] publicBytes = Base64.getDecoder().decode(pub.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        PublicKey pubKey = null;

        try {
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            pubKey = keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            throw new DataBaseOperationException("An error occurred while running encryption.");
        }


        return pubKey;
    }
}
