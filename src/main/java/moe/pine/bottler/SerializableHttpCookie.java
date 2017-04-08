package moe.pine.bottler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.net.HttpCookie;

/**
 * SerializableHttpCookie
 * Created by pine on 2017/04/08.
 */
public final class SerializableHttpCookie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nullable
    private String name;

    @Nullable
    private String value;

    @Nullable
    private String comment;

    @Nullable
    private String commentURL;
    private boolean toDiscard;

    @Nullable
    private String domain;
    private long maxAge = -1;

    @Nullable
    private String path;

    @Nullable
    private String portlist;
    private boolean secure;
    private boolean httpOnly;
    private int version = 1;

    public SerializableHttpCookie() {
    }

    /**
     * Create a new SerializableHttpCookie from a HttpCookie
     *
     * @param cookie An original cookie
     * @return SerializableHttpCookie that have same contents
     */
    @NotNull
    public static SerializableHttpCookie of(@NotNull HttpCookie cookie) {
        SerializableHttpCookie newCookie = new SerializableHttpCookie();
        newCookie.name = cookie.getName();
        newCookie.value = cookie.getValue();
        newCookie.comment = cookie.getComment();
        newCookie.commentURL = cookie.getCommentURL();
        newCookie.toDiscard = cookie.getDiscard();
        newCookie.domain = cookie.getDomain();
        newCookie.maxAge = cookie.getMaxAge();
        newCookie.path = cookie.getPath();
        newCookie.portlist = cookie.getPortlist();
        newCookie.secure = cookie.getSecure();
        newCookie.httpOnly = cookie.isHttpOnly();
        newCookie.version = cookie.getVersion();

        return newCookie;
    }

    /**
     * Convert to a new HttpCookie
     *
     * @return HttpCookie that have same contents
     * @throws IllegalStateException the name is null
     */
    @NotNull
    public HttpCookie toHttpCookie() {
        if (this.name == null) {
            throw new IllegalStateException("Illegal cookie name");
        }

        HttpCookie cookie = new HttpCookie(this.name, this.value);
        cookie.setComment(this.comment);
        cookie.setCommentURL(this.commentURL);
        cookie.setDiscard(this.toDiscard);
        cookie.setDomain(this.domain);
        cookie.setMaxAge(this.maxAge);
        cookie.setPath(this.path);
        cookie.setPortlist(this.portlist);
        cookie.setSecure(this.secure);
        cookie.setHttpOnly(this.httpOnly);
        cookie.setVersion(this.version);

        return cookie;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getValue() {
        return value;
    }

    public void setValue(@Nullable String value) {
        this.value = value;
    }

    @Nullable
    public String getComment() {
        return comment;
    }

    public void setComment(@Nullable String comment) {
        this.comment = comment;
    }

    @Nullable
    public String getCommentURL() {
        return commentURL;
    }

    public void setCommentURL(@Nullable String commentURL) {
        this.commentURL = commentURL;
    }

    public boolean getDiscard() {
        return toDiscard;
    }

    public void setDiscard(boolean toDiscard) {
        this.toDiscard = toDiscard;
    }

    @Nullable
    public String getDomain() {
        return domain;
    }

    public void setDomain(@Nullable String domain) {
        this.domain = domain;
    }

    public long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(long maxAge) {
        this.maxAge = maxAge;
    }

    @Nullable
    public String getPath() {
        return path;
    }

    public void setPath(@Nullable String path) {
        this.path = path;
    }

    @Nullable
    public String getPortlist() {
        return portlist;
    }

    public void setPortlist(@Nullable String portlist) {
        this.portlist = portlist;
    }

    public boolean getSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public boolean isHttpOnly() {
        return httpOnly;
    }

    public void setHttpOnly(boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
