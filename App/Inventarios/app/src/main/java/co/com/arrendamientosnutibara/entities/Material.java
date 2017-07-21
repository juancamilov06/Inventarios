package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jva807 on 21/07/2017.
 */

@Entity
public class Material{

    @Id
    private long id;
    @NotNull
    private String material;
    private String imgUrl;
    @Generated(hash = 1604018499)
    public Material(long id, @NotNull String material, String imgUrl) {
        this.id = id;
        this.material = material;
        this.imgUrl = imgUrl;
    }
    @Generated(hash = 1176792654)
    public Material() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMaterial() {
        return this.material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getImgUrl() {
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
