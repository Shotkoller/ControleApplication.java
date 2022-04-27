
package com.example.controle.controller;

import com.example.controle.entity.Livre;
import com.example.controle.repository.Livrepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emsi_api")
public class LivreController {
    private final Livrepo repo;
    LivreController(Livrepo repo)
    {
        this.repo = repo;
    }
    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/livres")
    List<Livre> all() {
        return repo.findAll();
    }
    // end::get-aggregate-root[]
    @PostMapping("/ajout_livre")
    Livre newLivre(Livre newLivre) {
        return repo.save(newLivre);
    }

    @GetMapping("/livres/{id}")
    Livre one(@PathVariable Long id) {

        return repo.findById(id).get();
    }
    @PutMapping("/livres/{id}")
    Livre replaceEmployee(@RequestBody Livre newLivre, @PathVariable Long id) {

        return repo.findById(id)
                .map(livre -> {
                    livre.setTitre(newLivre.getTitre());
                    livre.setMaisonEdition(newLivre.getMaisonEdition());
                    livre.SetDateSortie(newLivre.getDate_sortie());
                    livre.setAuteur(newLivre.getAuteur());
                    livre.SetNbrPage(newLivre.getNbr_page());
                    livre.setIsbn(newLivre.getIsbn());
                    livre.setIsDispo(newLivre.getIsDispo());
                    livre.setDateDernierConsu(newLivre.getDateDernierConsu());
                    return repo.save(livre);
                })
                .orElseGet(() -> {
                    newLivre.setId(id);
                    return repo.save(newLivre);
                });
    }

    @DeleteMapping("/livres/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repo.deleteById(id);
    }

}