package puc.droneentrega.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.droneentrega.error.AtributoNaoInformado;
import puc.droneentrega.model.Drone;
import puc.droneentrega.model.Operador;
import puc.droneentrega.model.Viagem;
import puc.droneentrega.model.Volume;
import puc.droneentrega.service.DroneService;
import puc.droneentrega.service.OperadorService;
import puc.droneentrega.service.ViagemService;
import puc.droneentrega.service.VolumeService;

import java.util.Date;
import java.util.Optional;

@Service
public class ViagemFacade {

    @Autowired
    private ViagemService viagemService;

    @Autowired
    private DroneService droneService;

    @Autowired
    private OperadorService operadorService;

    @Autowired
    private VolumeService volumeService;

    public void criarViagem(Long idDrone, Long idOperador, Long idVolume, String origemViagem, Date dataChegadaViagem, Date dataSaidaViagem, String destinoViagem, String instrucoesViagem) throws Exception {
        try {
            validarPreechimento(idDrone, idOperador, idVolume, origemViagem, dataChegadaViagem, destinoViagem);
            Optional<Drone> drone = droneService.get(idDrone);
            Optional<Operador> operador = operadorService.get(idOperador);
            Optional<Volume> volume = volumeService.get(idVolume);
            Viagem viagem = criarNovaViagem(drone.get(), operador.get(), volume.get(), origemViagem, dataChegadaViagem, dataSaidaViagem, destinoViagem, instrucoesViagem);
            viagemService.save(viagem);
        } catch (Exception ex){
            throw new Exception(ex);
        }

    }

    private Viagem criarNovaViagem(Drone drone, Operador operador, Volume volume, String origemViagem, Date dataChegadaViagem, Date dataSaidaViagem, String destinoViagem, String instrucoesViagem) {
        Viagem viagem = new Viagem();
        viagem.setDrone(drone);
        viagem.setOperador(operador);
        viagem.setVolume(volume);
        viagem.setOrigemViagem(origemViagem);
        viagem.setDataChegadaViagem(dataChegadaViagem);
        viagem.setDataSaidaViagem(dataSaidaViagem);
        viagem.setDestinoViagem(destinoViagem);
        viagem.setInstrucoesViagem(instrucoesViagem);
        return viagem;
    }

    private void validarPreechimento(Long idDrone, Long idOperador, Long idVolume, String origemViagem, Date dataSaidaViagem, String destinoViagem) throws AtributoNaoInformado {
        if (idDrone == null){
            throw new AtributoNaoInformado("Drone");
        }
        if (idOperador == null){
            throw new AtributoNaoInformado("Operador");
        }
        if (idVolume == null){
            throw new AtributoNaoInformado("Volume");
        }
        if (origemViagem.isEmpty()){
            throw new AtributoNaoInformado("Origem da Viagem");
        }
        if (dataSaidaViagem == null){
            throw new AtributoNaoInformado("Data de Saída da Viagem");
        }
        if (destinoViagem.isEmpty()){
            throw new AtributoNaoInformado("Destino da Viagem");
        }
    }
}
