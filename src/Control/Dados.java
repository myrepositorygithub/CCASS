package Control;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by thiago on 7/4/17.
 */
public class Dados {

    private final File pasta;
    private final File arquivo;
    ArrayList<Associado> associados;
    ArrayList<Convenio> convenios;


    public static final String HOME = System.getProperty("user.home") + "/CCASS/";

    public Dados() {
        System.out.println(HOME);

        pasta = new File(HOME);
        arquivo = new File(HOME + "data");
        if (pasta.exists()) {
            System.out.println("Folder exists");
            if (arquivo.exists()) {
                System.out.println("File exists");
                try {
                    carregaDados();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File does not exist");
                System.out.println("Creating...");
                try {
                    arquivo.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Folder does not exist");
            System.out.println("Creating Folder...");
            pasta.mkdir();
            System.out.println("Creating File...");
            try {
                arquivo.createNewFile();
                criaDados();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void carregaDados() throws IOException {
        //To do
        associados = new ArrayList<Associado>();
        convenios = new ArrayList<Convenio>();
        Associado novo;
        String linha;

        FileReader leitor = new FileReader(HOME + "data");
        BufferedReader bufferedReader = new BufferedReader(leitor);

        //ArrayList<String> dados = new ArrayList<String>();
        String dados[];
        while ((linha = bufferedReader.readLine()) != null) {
            System.out.println(linha);

            dados = linha.split("-");
            novo = new Associado(dados[0], dados[1], dados[2], "",dados[3], null);

            ControladoraPrincipal.associados.add(novo);
        }
        leitor.close();

    }


    private void criaDados() {
        associados = new ArrayList<Associado>();
        convenios = new ArrayList<Convenio>();

    }


    public void adicionaAssociado(Associado novo) {
        System.out.println(novo.toString());
        associados.add(novo);
        ControladoraPrincipal.associados.add(novo);
    }

    public void encerraPrograma() throws IOException {


        FileWriter escritor = new FileWriter(HOME + "data");

        for (Associado socio : associados) {
            System.out.println(">>" + socio.toString());
            escritor.write(socio.toString());
        }
        escritor.flush();
        escritor.flush();
    }


}
