package puc.droneentrega.error;

public class AtributoNaoInformado extends Exception {

    public AtributoNaoInformado(String nomeAtributo) {
        super("Atributo não informado: " + nomeAtributo);
    }
}
