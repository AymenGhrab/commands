package tn.esprit.com.foyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.foyer.entities.Bloc;
import tn.esprit.com.foyer.entities.Chambre;
import tn.esprit.com.foyer.services.ChambreServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    ChambreServices chambreServices;
    @GetMapping("/get-all-chambres")
    public List<Chambre> retrieveChambres(){
        return chambreServices.retrieveAllChambre();
    }
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chambreId){
        return chambreServices.retrieveChambre(chambreId);
    }
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre ch){
        return chambreServices.addChambre(ch);
    }

    @DeleteMapping("/delete-chambre/{chambre-id}")
    public void deleteChambre(@PathVariable("chambre-id") Long chambreId){
        chambreServices.removeChambre(chambreId);
    }

    @PutMapping ("affecterChambe/{nom-bloc}")
    public  void affecterChambre(@PathVariable("nom-bloc") String nomBloc, @RequestBody List<Long> numChambre ){


        chambreServices.affecterChambresABloc(numChambre,nomBloc) ;
    }

}
