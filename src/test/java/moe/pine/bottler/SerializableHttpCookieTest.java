package moe.pine.bottler;

import org.junit.Assert;

import java.net.HttpCookie;

/**
 * Test for SerializableHttpCookie
 * Created by pine on 2017/04/08
 */
public class SerializableHttpCookieTest {
    public void testOf() {
        HttpCookie cookie = new HttpCookie("name", "value");
        cookie.setComment("comment");
        cookie.setCommentURL("commentURL");
        cookie.setDiscard(true);
        cookie.setMaxAge(12345L);
        cookie.setPath("/");
        cookie.setPortlist("443");
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setVersion(10);

        SerializableHttpCookie newCookie = SerializableHttpCookie.of(cookie);
        Assert.assertEquals(cookie.getName(), newCookie.getName());
        Assert.assertEquals(cookie.getValue(), newCookie.getValue());
        Assert.assertEquals(cookie.getDiscard(), newCookie.getDiscard());
        Assert.assertEquals(cookie.getMaxAge(), newCookie.getMaxAge());
        Assert.assertEquals(cookie.getPath(), newCookie.getPath());
        Assert.assertEquals(cookie.getPortlist(), newCookie.getPortlist());
        Assert.assertEquals(cookie.getSecure(), newCookie.getSecure());
        Assert.assertEquals(cookie.isHttpOnly(), newCookie.isHttpOnly());
        Assert.assertEquals(cookie.getVersion(), newCookie.getVersion());
    }
}
