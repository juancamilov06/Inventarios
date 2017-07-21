package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jva807 on 21/07/2017.
 */

@Entity
public class ElementHasMaterial {

    @Id
    private long id;
    @NotNull
    private long materialId;
    @NotNull
    private long elementId;
    @Generated(hash = 383577376)
    public ElementHasMaterial(long id, long materialId, long elementId) {
        this.id = id;
        this.materialId = materialId;
        this.elementId = elementId;
    }
    @Generated(hash = 891143072)
    public ElementHasMaterial() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getMaterialId() {
        return this.materialId;
    }
    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }
    public long getElementId() {
        return this.elementId;
    }
    public void setElementId(long elementId) {
        this.elementId = elementId;
    }

}
