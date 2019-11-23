package digitalinnovation.example.app.service;

import digitalinnovation.example.app.dto.Soldado;
import org.springframework.stereotype.Service;

@Service
public class SoldadoService {

    public Soldado getSoldado(){
        return new Soldado();
    }

    public void salvarSoldado(Soldado soldado){
    }

}
