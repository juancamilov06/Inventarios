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
public class Element {

    @Id
    private long id;
    @NotNull
    private String name;
    @NotNull
    private long chapterId;

    @ToOne(joinProperty = "chapterId")
    private Chapter chapter;

    @ToMany
    @JoinEntity(
            entity = ElementHasMaterial.class,
            sourceProperty = "elementId",
            targetProperty = "materialId"
    )
    private List<Material> elementMaterials;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 686058481)
    private transient ElementDao myDao;

    @Generated(hash = 2135576737)
    public Element(long id, @NotNull String name, long chapterId) {
        this.id = id;
        this.name = name;
        this.chapterId = chapterId;
    }

    @Generated(hash = 386918278)
    public Element() {
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

    public long getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(long chapterId) {
        this.chapterId = chapterId;
    }

    @Generated(hash = 647692238)
    private transient Long chapter__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 453768668)
    public Chapter getChapter() {
        long __key = this.chapterId;
        if (chapter__resolvedKey == null || !chapter__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChapterDao targetDao = daoSession.getChapterDao();
            Chapter chapterNew = targetDao.load(__key);
            synchronized (this) {
                chapter = chapterNew;
                chapter__resolvedKey = __key;
            }
        }
        return chapter;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 776640969)
    public void setChapter(@NotNull Chapter chapter) {
        if (chapter == null) {
            throw new DaoException(
                    "To-one property 'chapterId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.chapter = chapter;
            chapterId = chapter.getId();
            chapter__resolvedKey = chapterId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1962497394)
    public List<Material> getElementMaterials() {
        if (elementMaterials == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MaterialDao targetDao = daoSession.getMaterialDao();
            List<Material> elementMaterialsNew = targetDao
                    ._queryElement_ElementMaterials(id);
            synchronized (this) {
                if (elementMaterials == null) {
                    elementMaterials = elementMaterialsNew;
                }
            }
        }
        return elementMaterials;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 718108314)
    public synchronized void resetElementMaterials() {
        elementMaterials = null;
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
    @Generated(hash = 493197685)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getElementDao() : null;
    }

}
