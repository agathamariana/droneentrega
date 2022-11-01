package puc.droneentrega.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.droneentrega.error.AtributoNaoInformado;
import puc.droneentrega.model.Drone;
import puc.droneentrega.service.DroneService;

@Service
public class DroneFacade {

    @Autowired
    private DroneService droneService;

    public void criarDrone(String nomeDrone, String modeloDrone, String corDrone, String anoDrone) throws Exception {

        try {
            validarPreechimento(nomeDrone, modeloDrone, corDrone, anoDrone);
            Drone drone = criarNovoDrone(nomeDrone, modeloDrone, corDrone, anoDrone);
            droneService.save(drone);
        } catch (Exception ex){
            throw new Exception(ex);
        }

    }

    private Drone criarNovoDrone(String nomeDrone, String modeloDrone, String corDrone, String anoDrone) {
        Drone drone = new Drone();
        drone.setNomeDrone(nomeDrone);
        drone.setModeloDrone(modeloDrone);
        drone.setCorDrone(corDrone);
        drone.setAnoDrone(anoDrone);
        return drone;
    }

    private void validarPreechimento(String nomeDrone, String modeloDrone, String corDrone, String anoDrone) throws AtributoNaoInformado {
        if (nomeDrone.isEmpty()){
            throw new AtributoNaoInformado("Nome do Drone");
        }
        if (modeloDrone.isEmpty()){
            throw new AtributoNaoInformado("Modelo do Drone");
        }
        if (corDrone.isEmpty()){
            throw new AtributoNaoInformado("Cor do Drone");
        }
        if (anoDrone.isEmpty()){
            throw new AtributoNaoInformado("Ano do Drone");
        }
    }

}
