package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import wad.repository.KategoriaRepository;

@Entity
public class Kategoria extends AbstractPersistable<Long> {

    private String nimi;
    @ManyToMany(mappedBy = "kategoriat")
    private List<Uutinen> uutiset;
    
    public Kategoria() {
    }
    
    public Kategoria(String n) {
        this.nimi = n;
    }

    public String getNimi() {
        return nimi;
    }

    public List<Uutinen> getUutiset() {
        if (uutiset == null) {
            this.uutiset = new ArrayList();
        }
        return uutiset;
    }

    public void addUutinen(Uutinen uutinen) {
        if (uutiset == null) {
            this.uutiset = new ArrayList();
        }
        uutiset.add(uutinen);
    }

    public void setUutiset(List<Uutinen> uutiset) {
        this.uutiset = uutiset;
    }

}
