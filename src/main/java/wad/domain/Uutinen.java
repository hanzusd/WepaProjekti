
package wad.domain;

import java.util.Date;
import javax.persistence.Entity;
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
    
    public Uutinen() {
        this.date = new Date();
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
