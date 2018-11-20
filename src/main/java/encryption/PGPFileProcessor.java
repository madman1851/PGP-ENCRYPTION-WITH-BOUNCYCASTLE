package encryption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

@Service
public class PGPFileProcessor {

    @Value("${passphrase}")
    private String passphrase;
    @Value("${keyFile}")
    private String keyFile;
    @Value("${passphrase}")
    private String inputFile;
    @Value("${passphrase}")
    private String outputFile;

    private boolean asciiArmored = false;

    private boolean integrityCheck = true;

    public boolean encrypt() throws Exception {
        FileInputStream keyIn = new FileInputStream(keyFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        PGPUtil.encryptFile(out, inputFile, PGPUtil.readPublicKey(keyIn),
                asciiArmored, integrityCheck);
        out.close();
        keyIn.close();
        return true;
    }

    public boolean decrypt() throws Exception {
        FileInputStream in = new FileInputStream(inputFile);
        FileInputStream keyIn = new FileInputStream(keyFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        PGPUtil.decryptFile(in, out, keyIn, passphrase.toCharArray());
        in.close();
        out.close();
        keyIn.close();
        return true;
    }

    public boolean isAsciiArmored() {
        return asciiArmored;
    }

    public void setAsciiArmored(boolean asciiArmored) {
        this.asciiArmored = asciiArmored;
    }

    public boolean isIntegrityCheck() {
        return integrityCheck;
    }

    public void setIntegrityCheck(boolean integrityCheck) {
        this.integrityCheck = integrityCheck;
    }

}