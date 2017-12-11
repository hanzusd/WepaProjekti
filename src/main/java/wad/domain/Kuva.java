package wad.domain;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kuva extends AbstractPersistable<Long> {
    @Lob
    private byte[] content;
    @OneToOne
    private Uutinen uutinen;

    public Uutinen getUutinen() {
        return uutinen;
    }

    public void setUutinen(Uutinen uutinen) {
        this.uutinen = uutinen;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}