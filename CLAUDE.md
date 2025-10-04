# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java project built with Gradle. It uses Java with JUnit 5 for testing.

## Common Commands

### Build and Run
- Build the project: `./gradlew build`
- Run the application: `./gradlew run`
- Clean build artifacts: `./gradlew clean`

### Testing
- Run all tests: `./gradlew test`
- Run a single test class: `./gradlew test --tests "ClassName"`
- Run a single test method: `./gradlew test --tests "ClassName.methodName"`

### Other Tasks
- List all available tasks: `./gradlew tasks`
- View dependencies: `./gradlew dependencies`

## Project Structure

- **Source code**: `src/main/java/org/example/`
- **Test code**: `src/test/java/`
- **Build configuration**: `build.gradle` (Gradle build file)
- **Settings**: `settings.gradle` (project name: 'claude-j')

## Dependencies

- JUnit Jupiter 5.10.0 (testing framework)
