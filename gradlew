#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
APP_HOME=$(cd "${0%/*}" && pwd)

# Use the gradle wrapper jar
CLASSPATH="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"

# Execute Gradle Wrapper
exec java -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"