package puc.droneentrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.droneentrega.model.Viagem;
import puc.droneentrega.repository.ViagemRepository;

import java.util.Optional;

@Service
public class ViagemService {

    ViagemRepository viagemRepository;

    @Autowired
    public ViagemService(ViagemRepository viagemRepository){
        this.viagemRepository = viagemRepository;
    }

    public Viagem save(Viagem viagem){
        return viagemRepository.save(viagem);
    }

    public Optional<Viagem> get(Long id) {
        return viagemRepository.findById(id);
    }

    public void delete(Viagem viagem) { viagemRepository.delete(viagem); }
}
