package Model;


import Control.CCASS;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class XMLParser {


    static XStream xstream = new XStream();


    public XMLParser() {
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.allowTypesByWildcard(new String[]{
                "com.*"
        });
        xstream.alias("Configuracoes", Configuracoes.class);
        xstream.alias("associados", Associado.class);
        xstream.alias("convenios", Convenio.class);
    }

    public static void unparseConfig(String xml) {

        xstream.alias("Configuracoes", Configuracoes.class);
        Configuracoes aux = (Configuracoes) xstream.fromXML(xml);
        CCASS.config = aux;
    }

    public static String parseConfig(Configuracoes aux) {

        String xml;
        xml = xstream.toXML(aux);
        return xml;
    }

    public static void unparseAssociados() {
    }

    public static void unparseConvenios() {

    }


}
