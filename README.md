GradleFmpp
==========

### FreeMarker PreProcessor wrapper as a Gradle Plugin
Want to use FMPP easily from gradle to parse your freemarker template?
By using this plugin it is just a matter of including this plugin dependency in your
buildscript and configure the arguments for FMPP in your build.gradle.

### Usage:
- Download and build/install with gradle.
- Now you can use it from your local .m2 repository from the project holding your template.

In your build.gradle:
```
buildscript {
  repositories {
    mavenLocal()
  }
  dependencies {
    classpath 'org.rogern.gradlefmpp:gradle_fmpp_plugin-all:1.0-SNAPSHOT'
  }
}
```

...and:

```
gradlefmppargs {
  fmppSourceRoot = '<your template path>'
  fmppOutputDir = '<output dir for generated code>'
  fmppIncludes = '**/*.ftl' // Or whatever file endings your templates have
  fmppReplaceExtension = 'ftl, java' // File ending replacements for generated code
  fmppData = '<any data input supported by FMPP>'
}
``` 

### Disclaimer
- This plugin is not yet available on any public repository but it may in the near future.
- Only the shown FMPP configurations are currently supported. More may be added soon for broader support.
- This plugin is based on FMPP version 0.9.15 and built into the fatJar.

