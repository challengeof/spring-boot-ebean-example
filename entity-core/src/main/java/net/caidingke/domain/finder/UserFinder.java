package net.caidingke.domain.finder;

import io.ebean.Finder;
import net.caidingke.domain.User;
import net.caidingke.domain.query.QUser;

/**
 * @author bowen
 */
public class UserFinder extends Finder<Long, User> {

    /**
     * Construct using the default EbeanServer.
     */
    public UserFinder() {
        super(User.class);
    }

    /**
     * Construct with a given EbeanServer.
     */
    public UserFinder(String serverName) {
        super(User.class, serverName);
    }

    /**
     * Start a new typed query.
     */
    public QUser where() {
        return new QUser(db());
    }

    /**
     * Start a new document store query.
     */
    public QUser text() {
        return new QUser(db()).text();
    }

}
