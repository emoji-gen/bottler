package moe.pine.bottler;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.List;

/**
 * Test for CookieStoreUtils
 * Created by pine on 2017/04/08
 */
public class CookieStoreUtilsTest {
    @Test
    public void testSaveTo() throws URISyntaxException, IOException {
        CookieManager cookieManager =
                new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieManager newCookieManager =
                new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieStore cookieStore = cookieManager.getCookieStore();
        CookieStore newCookieStore = newCookieManager.getCookieStore();

        URI uri = new URI("http://www.example.com");
        HttpCookie cookie = new HttpCookie("hello", "world");
        cookieStore.add(uri, cookie);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CookieStoreUtils.writeTo(cookieStore, os);
        cookieStore.removeAll();

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        IOUtils.closeQuietly(os);
        CookieStoreUtils.readFrom(newCookieStore, is);
        IOUtils.closeQuietly(is);

        List<HttpCookie> saveCookie = newCookieStore.get(uri);
        Assert.assertEquals("hello", saveCookie.get(0).getName());
        Assert.assertEquals("world", saveCookie.get(0).getValue());
    }
}
