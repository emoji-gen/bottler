package moe.pine.bottler;

import org.junit.Assert;
import org.junit.Test;

import java.net.HttpCookie;

/**
 * Test for SerializableHttpCookie
 * Created by pine on 2017/04/08
 */
public class SerializableHttpCookieTest {
    @Test
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
        cookie.setVersion(1);

        SerializableHttpCookie newCookie = SerializableHttpCookie.of(cookie);
        Assert.assertEquals(cookie.getName(), newCookie.getName());
        Assert.assertEquals(cookie.getValue(), newCookie.getValue());
        Assert.assertEquals(cookie.getComment(), newCookie.getComment());
        Assert.assertEquals(cookie.getCommentURL(), newCookie.getCommentURL());
        Assert.assertEquals(cookie.getDiscard(), newCookie.getDiscard());
        Assert.assertEquals(cookie.getMaxAge(), newCookie.getMaxAge());
        Assert.assertEquals(cookie.getPath(), newCookie.getPath());
        Assert.assertEquals(cookie.getPortlist(), newCookie.getPortlist());
        Assert.assertEquals(cookie.getSecure(), newCookie.getSecure());
        Assert.assertEquals(cookie.isHttpOnly(), newCookie.isHttpOnly());
        Assert.assertEquals(cookie.getVersion(), newCookie.getVersion());
    }

    @Test
    public void testToHttpCookie() {
        SerializableHttpCookie cookie = new SerializableHttpCookie();
        cookie.setName("name");
        cookie.setValue("value");
        cookie.setComment("comment");
        cookie.setDiscard(true);
        cookie.setMaxAge(12345L);
        cookie.setPath("/");
        cookie.setPortlist("443");
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setVersion(1);

        HttpCookie newCookie = cookie.toHttpCookie();
        Assert.assertEquals(newCookie.getName(), cookie.getName());
        Assert.assertEquals(newCookie.getValue(), cookie.getValue());
        Assert.assertEquals(newCookie.getComment(), cookie.getComment());
        Assert.assertEquals(newCookie.getCommentURL(), cookie.getCommentURL());
        Assert.assertEquals(newCookie.getDiscard(), cookie.getDiscard());
        Assert.assertEquals(newCookie.getMaxAge(), cookie.getMaxAge());
        Assert.assertEquals(newCookie.getPath(), cookie.getPath());
        Assert.assertEquals(newCookie.getPortlist(), cookie.getPortlist());
        Assert.assertEquals(newCookie.getSecure(), cookie.getSecure());
        Assert.assertEquals(newCookie.isHttpOnly(), cookie.isHttpOnly());
        Assert.assertEquals(newCookie.getVersion(), cookie.getVersion());
    }

    @Test(expected = IllegalStateException.class)
    public void testToHttpCookie_IllegalStateException() {
        SerializableHttpCookie cookie = new SerializableHttpCookie();
        cookie.toHttpCookie();
    }

    @Test
    public void testSetName() {
        SerializableHttpCookie cookie = new SerializableHttpCookie();
        Assert.assertNull(cookie.getName());

        cookie.setName("name");
        Assert.assertEquals("name", cookie.getName());
    }

    @Test
    public void testSetValue() {
        SerializableHttpCookie cookie = new SerializableHttpCookie();
        Assert.assertNull(cookie.getValue());

        cookie.setValue("value");
        Assert.assertEquals("value", cookie.getValue());
    }

    @Test
    public void testSetComment() {
        SerializableHttpCookie cookie = new SerializableHttpCookie();
        Assert.assertNull(cookie.getComment());

        cookie.setComment("comment");
        Assert.assertEquals("comment", cookie.getComment());
    }

    @Test
    public void testSetCommentURL() {
        SerializableHttpCookie cookie = new SerializableHttpCookie();
        Assert.assertNull(cookie.getCommentURL());

        cookie.setCommentURL("commentURL");
        Assert.assertEquals("commentURL", cookie.getCommentURL());
    }

    @Test
    public void testSetDiscard() {
        SerializableHttpCookie cookie = new SerializableHttpCookie();
        Assert.assertFalse(cookie.getDiscard());

        cookie.setDiscard(true);
        Assert.assertEquals(true, cookie.getDiscard());
    }

    @Test
    public void testSetMaxAge() {
        SerializableHttpCookie cookie = new SerializableHttpCookie();
        Assert.assertEquals(-1, cookie.getMaxAge());

        cookie.setMaxAge(12345L);
        Assert.assertEquals(12345L, cookie.getMaxAge());
    }
}
