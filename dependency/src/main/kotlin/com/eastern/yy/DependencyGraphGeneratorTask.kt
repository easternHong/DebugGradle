package com.eastern.yy

/**
 * Created by hongdongsheng on 18-8-11.
 */
import guru.nidi.graphviz.engine.Graphviz
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class DependencyGraphGeneratorTask : DefaultTask() {
    lateinit var generator: DependencyGraphGeneratorExtension.Generator // TODO does this need to be an input? Quick testing shows no.
    @InputFile lateinit var inputFile: File

    @OutputDirectory lateinit var outputDirectory: File

    @TaskAction
    fun run() {
        Const.dump("goo....")
        val graph = DotGenerator(project, generator).generateGraph()
        File(outputDirectory, generator.outputFileNameDot).writeText(graph.toString())

        val graphviz = Graphviz.fromGraph(graph)

        generator.outputFormats.forEach {
            graphviz.render(it).toFile(File(outputDirectory, generator.outputFileName))
            Const.dump("what:" + it.toString())
        }
    }
}