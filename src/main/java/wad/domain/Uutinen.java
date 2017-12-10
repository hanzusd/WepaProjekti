
package wad.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Uutinen extends AbstractPersistable<Long> {
    private String otsikko;
    private String leipateksti;
    private String ingressi;

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
