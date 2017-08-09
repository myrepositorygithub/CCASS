package Model;

import Control.CCASS;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by thiago on 7/4/17.
 */
public class Dados {

    private final File pasta;
    private final File dataFile;
    private final File configFile;
    public ArrayList<Associado> associados = new ArrayList<Associado>();
    public ArrayList<Convenio> convenios = new ArrayList<Convenio>();


    public static final String HOME = System.getProperty("user.home") + "/CCASS/";

    public Dados() {
        System.out.println(HOME);
        Boolean teste = false;
        pasta = new File(HOME);
        dataFile = new File(HOME + "data");
        configFile = new File(HOME + "config");
        if (pasta.exists()) {
            System.out.println("Folder " + HOME + " exists");
            if (dataFile.exists()) {
                System.out.println("File data exists");
                teste = true;
            } else {
                teste = false;
                System.out.println("File data does not exist");
                System.out.println("Creating...");
                try {
                    dataFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (configFile.exists()) {
                System.out.println("File config exists");
                teste = true;
            } else {
                System.out.println("File config does not exist");
                System.out.println("Creating...");
                try {
                    CCASS.config = new Configuracoes("15", "10", "4", "4");
                    configFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (teste) {
                try {
                    carregaDados();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Folder " + HOME + " does not exist");
            System.out.println("Creating Folder...");
            pasta.mkdir();
            System.out.println("Creating File...");
            try {
                dataFile.createNewFile();
                criaDados();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void carregaDados() throws IOException {
        //To do
        convenios = new ArrayList<Convenio>();
        Associado novo;
        String linha, config;

        FileReader leitor = new FileReader(HOME + "data");
        BufferedReader bufferedReader = new BufferedReader(leitor);

        String dados[];
        while ((linha = bufferedReader.readLine()) != null) {
            dados = linha.split(">");
            novo = new Associado(dados[0] + "", dados[1] + "", dados[2] + "", dados[3] + "", dados[4] + "", dados[5] + "", dados[6] + "");

            //ControladoraPrincipal.associados.add(novo);
            if (!associados.contains(novo))
                this.associados.add(novo);
        }
        leitor.close();


        leitor = new FileReader(HOME + "config");
        bufferedReader = new BufferedReader(leitor);
        config = "";
        while ((linha = bufferedReader.readLine()) != null) {
            config += linha;
        }
        XMLParser.unparseConfig(config);



    }


    private void criaDados() {
        associados = new ArrayList<Associado>();
        convenios = new ArrayList<Convenio>();

    }


    public void encerraPrograma() throws IOException {

        if (dataFile.exists()) {
            dataFile.delete();
        }

        FileWriter escritor = new FileWriter(HOME + "data");

        for (Associado socio : associados) {
            //System.out.println(">>" + socio.toString());
            escritor.write(socio.toString() + "\n");
        }
        escritor.flush();
        dataFile.setReadOnly();

        if (configFile.exists()) {
            configFile.delete();
        }

        escritor = new FileWriter(HOME + "config");
        escritor.write(XMLParser.parseConfig(CCASS.config));
        escritor.flush();
        //System.out.println(XMLParser.parseConfig(CCASS.config));


        //configFile.setReadOnly();
    }


    public static void descarrega(ArrayList<Associado> associados) {

        for (Associado aux :
                associados) {
            //To do
            // System.out.println(aux.toString());

        }


    }
}
