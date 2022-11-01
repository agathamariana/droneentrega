package puc.droneentrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puc.droneentrega.facade.DroneFacade;

@RestController
@RequestMapping(value = "/drone")
public class DroneController {

    DroneFacade droneFacade;

    @Autowired
    public DroneController(DroneFacade droneFacade) {
        this.droneFacade = droneFacade;
    }

    @PostMapping(path="/criar")
    public ResponseEntity<String> criarDrone(@RequestParam("nomeDrone") String nomeDrone,
                                              @RequestParam("modeloDrone") String modeloDrone,
                                              @RequestParam("corDrone") String corDrone,
                                              @RequestParam ("anoDrone") String anoDrone) throws Exception {
        droneFacade.criarDrone(nomeDrone, modeloDrone, corDrone, anoDrone);
        return new ResponseEntity<>("DRONE SALVO", HttpStatus.OK);
    }

}
