package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;

/**
 * Created by jva807 on 21/07/2017.
 */

@Entity
public class InventoryHasElementMaterial {

    @Id
    private long id;
    @NotNull
    private String status;
    private String imgUrl;
    @NotNull
    private long inventoryId;
    @NotNull
    private long elementMaterialId;
    @NotNull
    private long sectionId;
    @ToOne(joinProperty = "sectionId")
    private Section section;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 2054463784)
    private transient InventoryHasElementMaterialDao myDao;
    @Generated(hash = 277658736)
    private transient Long section__resolvedKey;
    
    @Generated(hash = 387186076)
    public InventoryHasElementMaterial(long id, @NotNull String status,
            String imgUrl, long inventoryId, long elementMaterialId,
            long sectionId) {
        this.id = id;
        this.status = status;
        this.imgUrl = imgUrl;
        this.inventoryId = inventoryId;
        this.elementMaterialId = elementMaterialId;
        this.sectionId = sectionId;
    }
    @Generated(hash = 749455735)
    public InventoryHasElementMaterial() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getImgUrl() {
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public long getInventoryId() {
        return this.inventoryId;
    }
    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }
    public long getElementMaterialId() {
        return this.elementMaterialId;
    }
    public void setElementMaterialId(long elementMaterialId) {
        this.elementMaterialId = elementMaterialId;
    }
    public long getSectionId() {
        return this.sectionId;
    }
    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1090999800)
    public Section getSection() {
        long __key = this.sectionId;
        if (section__resolvedKey == null || !section__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SectionDao targetDao = daoSession.getSectionDao();
            Section sectionNew = targetDao.load(__key);
            synchronized (this) {
                section = sectionNew;
                section__resolvedKey = __key;
            }
        }
        return section;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 423846855)
    public void setSection(@NotNull Section section) {
        if (section == null) {
            throw new DaoException(
                    "To-one property 'sectionId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.section = section;
            sectionId = section.getId();
            section__resolvedKey = sectionId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 4157406)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getInventoryHasElementMaterialDao() : null;
    }

}
