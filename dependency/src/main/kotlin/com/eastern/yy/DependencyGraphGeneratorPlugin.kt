package com.eastern.yy

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

/**
 * Created by hongdongsheng on 18-8-11.
 */
open class DependencyGraphGeneratorPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create("dependencyGraphGenerator", DependencyGraphGeneratorExtension::class.java)

        project.afterEvaluate {
            extension.generators.forEach {
                val task = project.tasks.create(it.gradleTaskName, DependencyGraphGeneratorTask::class.java)
                task.generator = it
                task.group = "reporting"
                task.description = "Generates a dependency graph${it.name.nonEmptyPrepend(" for ")}"
                task.inputFile = project.buildFile
                task.outputDirectory = File(project.buildDir, "reports/dependency-graph/")
                Const.dump(task.toString())
            }
        }
    }
}