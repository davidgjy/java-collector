import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

public class Main {
    public static void main(String ... args){

        Service service ;
        if(true == true){
            service = new ServiceSql();

        }else if(true == true){
            service = new ServiceFile();
        }



    }
}
