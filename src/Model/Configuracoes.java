package Model;

public class Configuracoes {

    public  int distanciaInicial;
    public  int distanciaIntermediaria;
    public  int deslocamentoEsquerda1;
    public  int deslocamentoEsquerda2;

    public Configuracoes(String distIni,String distInt,String desEsq1,String desEsq2) {

        distanciaInicial = Integer.parseInt(distIni);
        distanciaIntermediaria = Integer.parseInt(distInt);
        deslocamentoEsquerda1 = Integer.parseInt(desEsq1);
        deslocamentoEsquerda2 = Integer.parseInt(desEsq2);

    }

    public int getDistanciaInicial() {
        return distanciaInicial;
    }

    public  void setDistanciaInicial(int distanciaInicial) {
        distanciaInicial = distanciaInicial;
    }

    public  int getDistanciaIntermediaria() {
        return distanciaIntermediaria;
    }

    public  void setDistanciaIntermediaria(int distanciaIntermediaria) {
        distanciaIntermediaria = distanciaIntermediaria;
    }

    public  int getDeslocamentoEsquerda1() {
        return deslocamentoEsquerda1;
    }

    public  void setDeslocamentoEsquerda1(int deslocamentoEsquerda1) {
        deslocamentoEsquerda1 = deslocamentoEsquerda1;
    }

    public  int getDeslocamentoEsquerda2() {
        return deslocamentoEsquerda2;
    }

    public  void setDeslocamentoEsquerda2(int deslocamentoEsquerda2) {
        deslocamentoEsquerda2 = deslocamentoEsquerda2;
    }
}
