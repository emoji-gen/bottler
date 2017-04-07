# Bottler

:cookie: Cookie serializer and deserializer library for Java.

## Getting Started
TODO

## Usage

```java
CookieManager manager = CookieManager.getInstance();
CookieStore store = manager.getCookieStore();

ByteArrayOutputStream os = new ByteArrayOutputStream();
CookieStoreUtils.writeTo(store, os); // Save!

store.removeAll();

ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
CookieStoreUtils.readFrom(store, is); // Restore!!
```

## Test

```
$ ./gradlew clean test
```

## License
MIT &copy; Pine Mizune
