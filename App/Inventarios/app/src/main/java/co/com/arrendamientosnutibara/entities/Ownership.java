package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;
import org.greenrobot.greendao.DaoException;

/**
 * Created by jva807 on 21/07/2017.
 */


@Entity
public class Ownership {

    @Id
    private long id;
    @NotNull
    private int canon;
    @NotNull
    @Index(unique = true)
    private String address;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
    @NotNull
    private String ownerName;
    @NotNull
    private long typeId;
    @ToOne(joinProperty = "typeId")
    private Type type;

    @ToMany(referencedJoinProperty = "ownershipId")
    private List<Inventory> ownershipInventories;

    private String lessee;
    private String lesseePhone;
    private String neighborhood;
    private boolean isActive;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 813473387)
    private transient OwnershipDao myDao;
    @Generated(hash = 1487410595)
    public Ownership(long id, int canon, @NotNull String address, double latitude,
            double longitude, @NotNull String ownerName, long typeId, String lessee,
            String lesseePhone, String neighborhood, boolean isActive) {
        this.id = id;
        this.canon = canon;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ownerName = ownerName;
        this.typeId = typeId;
        this.lessee = lessee;
        this.lesseePhone = lesseePhone;
        this.neighborhood = neighborhood;
        this.isActive = isActive;
    }
    @Generated(hash = 1997402621)
    public Ownership() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getCanon() {
        return this.canon;
    }
    public void setCanon(int canon) {
        this.canon = canon;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getLatitude() {
        return this.latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return this.longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getOwnerName() {
        return this.ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public long getTypeId() {
        return this.typeId;
    }
    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }
    public String getLessee() {
        return this.lessee;
    }
    public void setLessee(String lessee) {
        this.lessee = lessee;
    }
    public String getLesseePhone() {
        return this.lesseePhone;
    }
    public void setLesseePhone(String lesseePhone) {
        this.lesseePhone = lesseePhone;
    }
    public String getNeighborhood() {
        return this.neighborhood;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public boolean getIsActive() {
        return this.isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    @Generated(hash = 506996655)
    private transient Long type__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 736320828)
    public Type getType() {
        long __key = this.typeId;
        if (type__resolvedKey == null || !type__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypeDao targetDao = daoSession.getTypeDao();
            Type typeNew = targetDao.load(__key);
            synchronized (this) {
                type = typeNew;
                type__resolvedKey = __key;
            }
        }
        return type;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1054705507)
    public void setType(@NotNull Type type) {
        if (type == null) {
            throw new DaoException(
                    "To-one property 'typeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.type = type;
            typeId = type.getId();
            type__resolvedKey = typeId;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1447177979)
    public List<Inventory> getOwnershipInventories() {
        if (ownershipInventories == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            InventoryDao targetDao = daoSession.getInventoryDao();
            List<Inventory> ownershipInventoriesNew = targetDao
                    ._queryOwnership_OwnershipInventories(id);
            synchronized (this) {
                if (ownershipInventories == null) {
                    ownershipInventories = ownershipInventoriesNew;
                }
            }
        }
        return ownershipInventories;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2095149870)
    public synchronized void resetOwnershipInventories() {
        ownershipInventories = null;
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
    @Generated(hash = 731988720)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOwnershipDao() : null;
    }

}
