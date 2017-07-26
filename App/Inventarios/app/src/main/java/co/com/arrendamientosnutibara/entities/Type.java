package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jva807 on 21/07/2017.
 */

@Entity
public class Type {

    @Id
    private long id;
    @NotNull
    private String type;

    @Generated(hash = 453093116)
    public Type(long id, @NotNull String type) {
        this.id = id;
        this.type = type;
    }
    @Generated(hash = 1782799822)
    public Type() {
    }
    
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }


}
