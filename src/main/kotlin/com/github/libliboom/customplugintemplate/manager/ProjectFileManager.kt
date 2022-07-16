package com.github.libliboom.customplugintemplate.manager

import com.github.libliboom.customplugintemplate.manager.Path.*
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiManager

enum class Path(val type: Int) {
    INTERACTOR(0), PRESENTER(1), VIEW(2), MODEL(3);
}

class ProjectFileManager(
    private val project: Project,
    appPath: String = "app/src/main/java",
    presentationPath: String = "presentation/src/main/java",
    repositoryPath: String = "repository/src/main/java",
    datasourcePath: String = "datasource/src/main/java",
    domainPath: String = "domain/src/main/java",
    interactorPath: String = "interactor/src/main/java",
    presenterPath: String = "presenter/src/main/java",
    viewPath: String = "view/src/main/java",
    modelPath: String = "model/src/main/java"
) {

    private var modularized = false
    private val virtualFiles = ProjectRootManager.getInstance(project).contentSourceRoots

    private val relativePaths = listOf(
        appPath, presentationPath, repositoryPath, datasourcePath, domainPath
    )

    private val resources = mutableListOf<Triple<Path, PsiDirectory?, String>>(
        Triple(INTERACTOR, null, interactorPath),
        Triple(PRESENTER, null, presenterPath),
        Triple(VIEW, null, viewPath),
        Triple(MODEL, null, modelPath)
    )

    fun dirOf(path: Path) =
        if (modularized) resources[path.type].second!! else resources[0].second!!

    fun init(modularized: Boolean = false): Boolean {
        relativePaths.forEachIndexed { idx, path ->
            virtualFile(virtualFiles, path)?.let {
                resources[idx] =
                    resources[idx].copy(second = PsiManager.getInstance(project).findDirectory(it))
            }
        }
        resources.forEach { println(it.second) }
        if (modularized and resources.any { it.second == null }) return false
        return true
    }

    private fun virtualFile(virtualFiles: Array<VirtualFile>, relativePath: String) =
        virtualFiles.firstOrNull { it.path.contains(relativePath) }
}