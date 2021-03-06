# Bottler &nbsp;[![Build Status](https://travis-ci.org/emoji-gen/bottler.svg?branch=master)](https://travis-ci.org/emoji-gen/bottler) [![codecov](https://codecov.io/gh/emoji-gen/bottler/branch/master/graph/badge.svg)](https://codecov.io/gh/emoji-gen/bottler)

:cookie: Cookie serializer and deserializer library for Java.

![](cookie.jpg)

## Getting Started
Please type it in your build.gradle file.

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'moe.pine:bottler:0.1.1'
}
```

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

## Development
### Test

```
$ ./gradlew clean check
```

### Upload Bintray

```
$ ./gradlew clean assemble bintrayUpload
```

## License
MIT &copy; [Emoji Generator](https://emoji-gen.ninja/)
