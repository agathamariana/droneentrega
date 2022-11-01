package puc.droneentrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puc.droneentrega.model.Operador;
import puc.droneentrega.repository.OperadorRepository;

import java.util.Optional;

@Service
public class OperadorService {

    OperadorRepository operadorRepository;

    @Autowired
    public OperadorService(OperadorRepository operadorRepository){
        this.operadorRepository = operadorRepository;
    }

    public Operador save(Operador operador){
        return operadorRepository.save(operador);
    }

    public Optional<Operador> get(Long id) {
        return operadorRepository.findById(id);
    }

    public void delete(Operador operador) { operadorRepository.delete(operador); }
}
