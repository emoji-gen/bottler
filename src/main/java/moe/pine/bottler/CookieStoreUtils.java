package moe.pine.bottler;

import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * CookieStoreUtils
 * Created by pine on 2017/04/08.
 */
public final class CookieStoreUtils {
    public static void writeTo(
            @NotNull CookieStore store,
            @NotNull OutputStream stream
    ) throws IOException {
        HashMap<URI, List<SerializableHttpCookie>> cookieMap =
                new HashMap<URI, List<SerializableHttpCookie>>();

        List<URI> uris = store.getURIs();
        for (URI uri : uris) {
            List<HttpCookie> cookies = store.get(uri);
            List<SerializableHttpCookie> serializableHttpCookies =
                    new ArrayList<SerializableHttpCookie>(cookies.size());
            for (HttpCookie cookie : cookies) {
                serializableHttpCookies.add(SerializableHttpCookie.of(cookie));
            }
            cookieMap.put(uri, serializableHttpCookies);
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(os);
            oos.writeObject(cookieMap);
            oos.flush();
            stream.write(os.toByteArray());
        } finally {
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(oos);
        }
    }

    @SuppressWarnings("unchecked")
    public static void readFrom(
            @NotNull CookieStore store,
            @NotNull InputStream stream
    ) throws IOException {
        HashMap<URI, List<SerializableHttpCookie>> cookieMap = null;

        ByteArrayInputStream is = new ByteArrayInputStream(IOUtils.toByteArray(stream));
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(is);
            Object object = ois.readObject();
            if (object instanceof HashMap) {
                cookieMap = (HashMap<URI, List<SerializableHttpCookie>>) object;
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(ois);
        }

        if (cookieMap == null) return;

        for (URI uri : cookieMap.keySet()) {
            List<SerializableHttpCookie> cookies = cookieMap.get(uri);
            for (SerializableHttpCookie cookie : cookies) {
                store.add(uri, cookie.toHttpCookie());
            }
        }

    }
}
