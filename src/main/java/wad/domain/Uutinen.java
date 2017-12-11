
package wad.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Uutinen extends AbstractPersistable<Long> {
    private String otsikko;
    private String leipateksti;
    private String ingressi;
    private Date date;
    @OneToOne
    private Kuva kuva;
    @ManyToMany
    private List<Kategoria> kategoriat;

    public List<Kategoria> getKategoriat() {
        if(this.kategoriat == null) {
            this.kategoriat = new ArrayList<>(); 
        }
        return kategoriat;
    }

    public void setKategoriat(List<Kategoria> kategoriat) {
        this.kategoriat = kategoriat;
    }
    
    public void addKategoria(Kategoria kategoria) {
        if(this.kategoriat == null) {
            this.kategoriat = new ArrayList<>(); 
        }
        this.kategoriat.add(kategoria);
    }
    
    public Uutinen() {
        this.date = new Date();
    }
    
    public Date getDate() {
        return date;
    }

    public Kuva getKuva() {
        return kuva;
    }
    
    public void setKuva(Kuva kuva) {
        this.kuva = kuva;
    }

    public String getIngressi() {
        return ingressi;
    }

    public void setIngressi(String ingressi) {
        this.ingressi = ingressi;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public String getLeipateksti() {
        return leipateksti;
    }

    public void setLeipateksti(String leipateksti) {
        this.leipateksti = leipateksti;
    }
    
}
