package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by jva807 on 21/07/2017.
 */

@Entity
public class Route {

    @Id
    private long id;
    @NotNull
    private boolean is_finished;

    @ToMany
    @JoinEntity(
            entity = RouteHasOwnership.class,
            sourceProperty = "routeId",
            targetProperty = "ownershipId"
    )
    private List<Ownership> ownershipsInRoute;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1511175683)
    private transient RouteDao myDao;

    @Generated(hash = 2137650301)
    public Route(long id, boolean is_finished) {
        this.id = id;
        this.is_finished = is_finished;
    }

    @Generated(hash = 467763370)
    public Route() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getIs_finished() {
        return this.is_finished;
    }

    public void setIs_finished(boolean is_finished) {
        this.is_finished = is_finished;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1241880762)
    public List<Ownership> getOwnershipsInRoute() {
        if (ownershipsInRoute == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OwnershipDao targetDao = daoSession.getOwnershipDao();
            List<Ownership> ownershipsInRouteNew = targetDao
                    ._queryRoute_OwnershipsInRoute(id);
            synchronized (this) {
                if (ownershipsInRoute == null) {
                    ownershipsInRoute = ownershipsInRouteNew;
                }
            }
        }
        return ownershipsInRoute;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2098495803)
    public synchronized void resetOwnershipsInRoute() {
        ownershipsInRoute = null;
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
    @Generated(hash = 1333897230)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRouteDao() : null;
    }


}
