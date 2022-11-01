package puc.droneentrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import puc.droneentrega.facade.VolumeFacade;

@RestController
@RequestMapping(value = "/volume")
public class VolumeController {

    VolumeFacade volumeFacade;

    @Autowired
    public VolumeController(VolumeFacade volumeFacade) {
        this.volumeFacade = volumeFacade;
    }

    @PostMapping(path="/criar")
    public ResponseEntity<String> criarVolume(@RequestParam("nomeVolume") String nomeVolume,
                                              @RequestParam("metragemVolume") Double metragemVolume,
                                              @RequestParam("pesoVolume") Double pesoVolume,
                                              @RequestParam ("valorVolume") Double valorVolume) throws Exception {
        volumeFacade.criarVolume(nomeVolume, metragemVolume, pesoVolume, valorVolume);
        return new ResponseEntity<>("VOLUME SALVO", HttpStatus.OK);
    }
}
