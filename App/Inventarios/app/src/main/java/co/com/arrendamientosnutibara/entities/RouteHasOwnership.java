package co.com.arrendamientosnutibara.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jva807 on 21/07/2017.
 */

@Entity
public class RouteHasOwnership {

    @Id
    private long id;
    @NotNull
    private long routeId;
    @NotNull
    private long ownershipId;
    @Generated(hash = 2131128274)
    public RouteHasOwnership(long id, long routeId, long ownershipId) {
        this.id = id;
        this.routeId = routeId;
        this.ownershipId = ownershipId;
    }
    @Generated(hash = 497129072)
    public RouteHasOwnership() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getRouteId() {
        return this.routeId;
    }
    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }
    public long getOwnershipId() {
        return this.ownershipId;
    }
    public void setOwnershipId(long ownershipId) {
        this.ownershipId = ownershipId;
    }


}
