package puc.droneentrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import puc.droneentrega.facade.ViagemFacade;

import java.util.Date;

@RestController
@RequestMapping(value = "/viagem")
public class ViagemController {

    ViagemFacade viagemFacade;

    @Autowired
    public ViagemController(ViagemFacade viagemFacade) {
        this.viagemFacade = viagemFacade;
    }

    @PostMapping(path="/criar")
    public ResponseEntity<String> criarViagem(@RequestParam("idDrone") Long idDrone,
                                              @RequestParam("idOperador") Long idOperador,
                                              @RequestParam("idVolume") Long idVolume,
                                              @RequestParam("origemViagem") String origemViagem,
                                              @RequestParam("dataChegadaViagem") Date dataChegadaViagem,
                                              @RequestParam("dataSaidaViagem") Date dataSaidaViagem,
                                              @RequestParam("destinoViagem") String destinoViagem,
                                              @RequestParam("instrucoesViagem") String instrucoesViagem) throws Exception {
        viagemFacade.criarViagem(idDrone, idOperador, idVolume, origemViagem, dataChegadaViagem, dataSaidaViagem, destinoViagem, instrucoesViagem);
        return new ResponseEntity<>("VIAGEM SALVO", HttpStatus.OK);
    }


}
