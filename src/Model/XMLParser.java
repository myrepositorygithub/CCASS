package Model;


import Control.CCASS;
import com.thoughtworks.xstream.XStream;

public class XMLParser {



    XStream xstream = new XStream();


    public XMLParser(){
        xstream.alias("associado",Associado.class);
        xstream.alias("convenio",Convenio.class);

        for (Associado aux :
                CCASS.dados.associados) {
            //System.out.println(xstream.toXML(aux));
        }
    }

}
