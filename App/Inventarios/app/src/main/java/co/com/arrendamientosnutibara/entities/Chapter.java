package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
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
public class Chapter {

    @Id
    private long id;
    @NotNull
    private String chapter;
    @NotNull
    private long sectionId;

    @ToOne(joinProperty = "sectionId")
    private Section section;

    @ToMany(referencedJoinProperty = "chapterId")
    private List<Element> chapterElements;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1364227941)
    private transient ChapterDao myDao;

    @Generated(hash = 699236631)
    public Chapter(long id, @NotNull String chapter, long sectionId) {
        this.id = id;
        this.chapter = chapter;
        this.sectionId = sectionId;
    }

    @Generated(hash = 393170288)
    public Chapter() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChapter() {
        return this.chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public long getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    @Generated(hash = 277658736)
    private transient Long section__resolvedKey;

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
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1727656814)
    public List<Element> getChapterElements() {
        if (chapterElements == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ElementDao targetDao = daoSession.getElementDao();
            List<Element> chapterElementsNew = targetDao
                    ._queryChapter_ChapterElements(id);
            synchronized (this) {
                if (chapterElements == null) {
                    chapterElements = chapterElementsNew;
                }
            }
        }
        return chapterElements;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1081348388)
    public synchronized void resetChapterElements() {
        chapterElements = null;
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
    @Generated(hash = 1600057230)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getChapterDao() : null;
    }

}
