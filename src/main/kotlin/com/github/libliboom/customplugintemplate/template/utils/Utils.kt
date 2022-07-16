package com.github.libliboom.customplugintemplate.template.utils

import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFileFactory
import org.jetbrains.kotlin.idea.KotlinLanguage
import java.util.*

fun String.asKt() = "${this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}.kt"

val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
fun String.toSnakeCase() = camelRegex.replace(this) { "_${it.value}" }.lowercase()

fun String.save(srcDir: PsiDirectory, subDirPath: String, fileName: String) {
  try {
    val destDir = subDirPath.split(".").toDir(srcDir)
    val psiFile = PsiFileFactory
      .getInstance(srcDir.project)
      .createFileFromText(fileName, KotlinLanguage.INSTANCE, this)
    destDir.add(psiFile)
  } catch (exc: Exception) {
    exc.printStackTrace()
  }
}

fun List<String>.toDir(srcDir: PsiDirectory): PsiDirectory {
  var result = srcDir
  forEach {
    result = result.findSubdirectory(it) ?: result.createSubdirectory(it)
  }
  return result
}