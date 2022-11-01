package puc.droneentrega.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.droneentrega.error.AtributoNaoInformado;
import puc.droneentrega.model.Operador;
import puc.droneentrega.service.OperadorService;

import java.util.Date;

@Service
public class OperadorFacade {

    @Autowired
    private OperadorService operadorService;

    public void criarOperador(String nomeOperador, String usernameOperador, Date dataNascimentoOperador, Long cpfOperador, Long rgOperador, String ufRgOperador, Date dataEmissaoRgOperador) throws Exception {
        try {
            validarPreechimento(nomeOperador, usernameOperador, dataNascimentoOperador, cpfOperador, rgOperador, ufRgOperador, dataEmissaoRgOperador);
            Operador operador = criarNovoOperador(nomeOperador, usernameOperador, dataNascimentoOperador, cpfOperador, rgOperador, ufRgOperador, dataEmissaoRgOperador);
            operadorService.save(operador);
        } catch (Exception ex){
            throw new Exception(ex);
        }
    }

    private Operador criarNovoOperador(String nomeOperador, String usernameOperador, Date dataNascimentoOperador, Long cpfOperador, Long rgOperador, String ufRgOperador, Date dataEmissaoRgOperador) {
        Operador operador = new Operador();
        operador.setNomeOperador(nomeOperador);
        operador.setUsernameOperador(usernameOperador);
        operador.setDataNascimentoOperador(dataNascimentoOperador);
        operador.setCpfOperador(cpfOperador);
        operador.setRgOperador(rgOperador);
        operador.setUfRgOperador(ufRgOperador);
        operador.setDataEmissaoRgOperador(dataEmissaoRgOperador);
        return operador;
    }

    private void validarPreechimento(String nomeOperador, String usernameOperador, Date dataNascimentoOperador, Long cpfOperador, Long rgOperador, String ufRgOperador, Date dataEmissaoRgOperador) throws AtributoNaoInformado {
        if (nomeOperador.isEmpty()){
            throw new AtributoNaoInformado("Nome do Operador");
        }
        if (usernameOperador.isEmpty()){
            throw new AtributoNaoInformado("Username do Operador");
        }
        if (dataNascimentoOperador == null){
            throw new AtributoNaoInformado("Data de Nascimento do Operador");
        }
        if (cpfOperador == null){
            throw new AtributoNaoInformado("CPF do Operador");
        }
        if (rgOperador == null){
            throw new AtributoNaoInformado("RG do Operador");
        }
        if (ufRgOperador.isEmpty()){
            throw new AtributoNaoInformado("UF do RG do Operador");
        }
        if (dataEmissaoRgOperador == null){
            throw new AtributoNaoInformado("Data de Emissão do Operador");
        }
    }
}
