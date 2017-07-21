package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by jva807 on 21/07/2017.
 */

@Entity
public class Section {

    @Id
    private long id;
    @NotNull
    private String section;
    @NotNull
    private long typeId;

    @ToOne(joinProperty = "typeId")
    private Type type;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1718547978)
    private transient SectionDao myDao;

    @Generated(hash = 1066545172)
    public Section(long id, @NotNull String section, long typeId) {
        this.id = id;
        this.section = section;
        this.typeId = typeId;
    }

    @Generated(hash = 111791983)
    public Section() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
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
    @Generated(hash = 479686395)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSectionDao() : null;
    }


}
