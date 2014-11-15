package org.rogern.gradlefmpp

import org.gradle.api.Plugin
import org.gradle.api.Project

class FmppPlugin implements Plugin<Project> {

  @Override
  void apply(Project project) {
    project.extensions.create("gradlefmppargs", FmppPluginExtension)

    project.task('fmpp') << {
      project.ant.taskdef(name: 'fmpp', classname: 'fmpp.tools.AntTask', classpath: project.buildscript.configurations.classpath.asPath)
      def props = project.extensions.gradlefmppargs
      project.ant.fmpp(sourceRoot: props.fmppSourceRoot, outputRoot: props.fmppOutputDir, includes: props.fmppIncludes,
          replaceExtension: props.fmppReplaceExtension, data: props.fmppData)
    }
  }
}