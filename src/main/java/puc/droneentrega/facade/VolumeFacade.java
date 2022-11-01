package puc.droneentrega.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.droneentrega.error.AtributoNaoInformado;
import puc.droneentrega.model.Volume;
import puc.droneentrega.service.VolumeService;

@Service
public class VolumeFacade {

    @Autowired
    private VolumeService volumeService;

    public void criarVolume(String nomeVolume, Double metragemVolume, Double pesoVolume, Double valorVolume) throws Exception {
        try {
            validarPreechimento(nomeVolume, metragemVolume, pesoVolume, valorVolume);
            Volume volume = criarNovoVolume(nomeVolume, metragemVolume, pesoVolume, valorVolume);
            volumeService.save(volume);
        } catch (Exception ex){
            throw new Exception(ex);
        }

    }

    private Volume criarNovoVolume(String nomeVolume, Double metragemVolume, Double pesoVolume, Double valorVolume) {
        Volume volume = new Volume();
        volume.setNomeVolume(nomeVolume);
        volume.setMetragemVolume(metragemVolume);
        volume.setPesoVolume(pesoVolume);
        volume.setValorVolume(valorVolume);
        return volume;
    }

    private void validarPreechimento(String nomeVolume, Double metragemVolume, Double pesoVolume, Double valorVolume) throws AtributoNaoInformado {
        if (nomeVolume.isEmpty()){
            throw new AtributoNaoInformado("Nome do Volume");
        }
        if (metragemVolume == null){
            throw new AtributoNaoInformado("Metragem do Volume");
        }
        if (pesoVolume == null){
            throw new AtributoNaoInformado("Peso do Volume");
        }
        if (valorVolume == null){
            throw new AtributoNaoInformado("Valor do Volume");
        }
    }
}
