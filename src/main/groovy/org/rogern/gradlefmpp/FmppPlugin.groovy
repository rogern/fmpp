package org.rogern.gradlefmpp

import org.gradle.api.Plugin
import org.gradle.api.Project

class FmppPlugin implements Plugin<Project> {

  @Override
  void apply(Project project) {
    project.extensions.create("fmpp", FmppPluginExtension)

    project.task('fmpp') << {
      ant.taskdef(name: 'fmpp', classname: 'fmpp.tools.AntTask', classpath: configurations.fmpp.asPath)
      def props = project.extensions.fmpp
      ant.fmpp(sourceRoot: props.fmppSourceRoot, outputRoot: props.fmppOutputDir, includes: props.fmppIncludes,
          replaceExtension: props.fmppReplaceExtension, data: props.fmppData)
    }
  }
}