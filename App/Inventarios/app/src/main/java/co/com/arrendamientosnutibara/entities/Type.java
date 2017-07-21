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
    private String name;
    @Generated(hash = 734309441)
    public Type(long id, @NotNull String name) {
        this.id = id;
        this.name = name;
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
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
