package net.caidingke.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.ebean.annotation.Cache;
import io.ebean.annotation.DbComment;
import io.ebean.annotation.Index;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.caidingke.domain.finder.UserFinder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

/**
 * @author bowen.
 */
@Entity
@Getter
@Setter
@ToString
@Cache
public class User extends BaseModel{

    public static final UserFinder find = new UserFinder();

    @Index
    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String realName;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String salt;

    @DbComment("The date the adminUser first registered")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate registered;
}
