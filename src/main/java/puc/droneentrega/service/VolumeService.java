package puc.droneentrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.droneentrega.model.Drone;
import puc.droneentrega.model.Volume;
import puc.droneentrega.repository.DroneRepository;
import puc.droneentrega.repository.VolumeRepository;

import java.util.Optional;

@Service
public class VolumeService {

    VolumeRepository volumeRepository;

    @Autowired
    public VolumeService(VolumeRepository volumeRepository){
        this.volumeRepository = volumeRepository;
    }

    public Volume save(Volume volume){
        return volumeRepository.save(volume);
    }

    public Optional<Volume> get(Long id) {
        return volumeRepository.findById(id);
    }

    public void delete(Volume volume) { volumeRepository.delete(volume); }
}
