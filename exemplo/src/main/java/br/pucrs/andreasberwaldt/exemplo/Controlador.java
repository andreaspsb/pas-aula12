package br.pucrs.andreasberwaldt.exemplo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class Controlador {
    private List<Placa> placas = new ArrayList<>();

    @GetMapping("placas/valida/{placa}")
    public long validaPlaca(@PathVariable(value = "placa") String placa) {
        return placas.stream().filter(p->p.getPlaca().contains(placa)).count();
    }    

}
