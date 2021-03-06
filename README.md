Dota 2 API
==========
The Dota 2 API is a project I've been working on for a little while 
the main aim of the project is to make a java port of the API for Dota 2 
that is as developer friendly as possible. Please note most of the enums are
generated and that's why they have odd names, I'll get around to adding the enum
generation code once I make non-spaghetti. Current plans for the new version of the
enum generation look to be generating patch files at build and patching the enum
classes with their respective enums, so that every build on Jenkins will ensure that
the enums are kept up to date and maintained.

Usage
-----
You can get the API from my Maven Repo:
```XML
<repository>
    <id>dragovorn-repo</id>
    <url>http://repo.dragovorn.com/</url>
</repository>
```
Then you can make it a dependency:
```XML
<dependency>
    <groupId>com.dragovorn</groupId>
    <artifactId>dota-api</artifactId>
    <version>0.0.6</version>
</dependency>
```
Then you can make an object for the API by doing:
```Java
IDota dota = new Dota("YOUR_API_KEY");
```

Then to run operations on the API use some of the provided methods,
please beware that bulk request methods return `DotaMatchReduced` 
because the bulk api methods don't return a full `DotaMatch` object.

Dependencies
------------
- Guava
- org.json
- Apache HTTP

**ALL DEPENDENCIES ARE SHADED INTO THE JAR!**

License
-------
MIT

Help Me!
--------
You could help by making a pull request and improving the codebase/adding features, or even by reporting an issue, if you want
to help without much effort you could [Donate](https://twitch.streamlabs.com/dragovorn#/ "My Streamlabs Donation Link"),
or if you are interested in watching me play (or work) on [Twitch](https://twitch.tv/dragovorn "My Twitch Link")!
You can join my [Discord](http://discord.gg/Q4Pak66 "My Discord Invite Link") to hangout and talk, if you have any
questions just send a message to `Dragovorn#0920` and I'll attempt to answer your question in a timely manner.