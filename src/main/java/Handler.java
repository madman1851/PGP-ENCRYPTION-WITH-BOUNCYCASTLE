import encryption.PGPFileProcessor;
import encryption.Spark;
import encryption.hdfsFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;



@ContextConfiguration(classes = SpringConfigurator.class)
public class Handler {

    @Autowired
    static PGPFileProcessor pgpFileProcessor;

    @Autowired
    static Spark spark;

    @Autowired
    static encryption.hdfsFileReader hdfsFileReader;


    public static void main(String[] args)throws Exception{
        if(args[0]=="1"){
            spark.readFile();
            pgpFileProcessor.encrypt();
        }
        if(args[0]=="2"){
            hdfsFileReader.readFile();
            pgpFileProcessor.decrypt();
        }
    }


}
