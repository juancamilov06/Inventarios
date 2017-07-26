package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by jva807 on 21/07/2017.
 */

@Entity
public class Inventory {

    @Id
    private long id;
    private String observations;
    @NotNull
    private long ownershipId;
    @ToOne(joinProperty = "ownershipId")
    private Ownership ownership;
    @NotNull
    private long userId;
    @NotNull
    private boolean isFinished;

    @ToMany
    @JoinEntity(
            entity = InventoryHasElementMaterial.class,
            sourceProperty = "inventoryId",
            targetProperty = "elementMaterialId"
    )
    private List<ElementHasMaterial> elementsInInventory;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 433391049)
    private transient InventoryDao myDao;

    @Generated(hash = 337038447)
    public Inventory(long id, String observations, long ownershipId, long userId,
            boolean isFinished) {
        this.id = id;
        this.observations = observations;
        this.ownershipId = ownershipId;
        this.userId = userId;
        this.isFinished = isFinished;
    }

    @Generated(hash = 375708430)
    public Inventory() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservations() {
        return this.observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public long getOwnershipId() {
        return this.ownershipId;
    }

    public void setOwnershipId(long ownershipId) {
        this.ownershipId = ownershipId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    @Generated(hash = 1763863372)
    private transient Long ownership__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1029231392)
    public Ownership getOwnership() {
        long __key = this.ownershipId;
        if (ownership__resolvedKey == null
                || !ownership__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OwnershipDao targetDao = daoSession.getOwnershipDao();
            Ownership ownershipNew = targetDao.load(__key);
            synchronized (this) {
                ownership = ownershipNew;
                ownership__resolvedKey = __key;
            }
        }
        return ownership;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 29869715)
    public void setOwnership(@NotNull Ownership ownership) {
        if (ownership == null) {
            throw new DaoException(
                    "To-one property 'ownershipId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.ownership = ownership;
            ownershipId = ownership.getId();
            ownership__resolvedKey = ownershipId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1928766690)
    public List<ElementHasMaterial> getElementsInInventory() {
        if (elementsInInventory == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ElementHasMaterialDao targetDao = daoSession.getElementHasMaterialDao();
            List<ElementHasMaterial> elementsInInventoryNew = targetDao
                    ._queryInventory_ElementsInInventory(id);
            synchronized (this) {
                if (elementsInInventory == null) {
                    elementsInInventory = elementsInInventoryNew;
                }
            }
        }
        return elementsInInventory;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1997643926)
    public synchronized void resetElementsInInventory() {
        elementsInInventory = null;
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
    @Generated(hash = 1763418221)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getInventoryDao() : null;
    }
}
