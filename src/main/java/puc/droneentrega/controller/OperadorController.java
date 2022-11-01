package puc.droneentrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import puc.droneentrega.facade.OperadorFacade;

import java.util.Date;

@RestController
@RequestMapping(value = "/operador")
public class OperadorController {

    OperadorFacade operadorFacade;

    @Autowired
    public OperadorController(OperadorFacade operadorFacade) {
        this.operadorFacade = operadorFacade;
    }

    @PostMapping(path="/criar")
    public ResponseEntity<String> criarOperador(@RequestParam("nomeOperador") String nomeOperador,
                                                @RequestParam("usernameOperador") String usernameOperador,
                                                @RequestParam("dataNascimentoOperador") Date dataNascimentoOperador,
                                                @RequestParam("cpfOperador") Long cpfOperador,
                                                @RequestParam("rgOperador") Long rgOperador,
                                                @RequestParam("ufRgOperador") String ufRgOperador,
                                                @RequestParam("dataEmissaoRgOperador") Date dataEmissaoRgOperador) throws Exception {
        operadorFacade.criarOperador(nomeOperador, usernameOperador, dataNascimentoOperador, cpfOperador, rgOperador, ufRgOperador, dataEmissaoRgOperador);
        return new ResponseEntity<>("OPERADOR SALVO", HttpStatus.OK);
    }
}
