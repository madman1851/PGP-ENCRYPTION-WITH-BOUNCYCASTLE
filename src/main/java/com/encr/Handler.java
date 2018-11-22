package com.encr;

import com.encr.encryption.PGPFileProcessor;
import com.encr.encryption.Spark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;



@ContextConfiguration(classes = SpringConfigurator.class)
@Service
public class Handler {


    public static void main(String[] args)throws Exception{
        Handler h = new Handler();
        h.start(args);
    }

    @Autowired
    PGPFileProcessor pgpFileProcessor;

    @Autowired
    Spark spark;

    @Autowired
    com.encr.encryption.hdfsFileReader hdfsFileReader;

    @Value("${args}")
    String _args;

    private void start(String[] args) throws Exception{
        if(_args=="1"){
            spark.readFile();
            pgpFileProcessor.encrypt();
        }
        if(_args=="2"){
            hdfsFileReader.readFile();
            pgpFileProcessor.decrypt();
        }
    }


}
