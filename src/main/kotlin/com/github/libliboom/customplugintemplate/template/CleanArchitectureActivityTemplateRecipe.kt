package com.github.libliboom.customplugintemplate.template

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.libliboom.customplugintemplate.listeners.MyProjectManagerListener.Companion.projectInstance
import com.github.libliboom.customplugintemplate.manager.PackageManager
import com.github.libliboom.customplugintemplate.manager.Path.*
import com.github.libliboom.customplugintemplate.manager.ProjectFileManager
import com.github.libliboom.customplugintemplate.manager.addPackageName
import com.github.libliboom.customplugintemplate.template.klass.*
import com.github.libliboom.customplugintemplate.template.utils.asKt
import com.github.libliboom.customplugintemplate.template.utils.save

fun RecipeExecutor.cleanArchFragmentTemplate(
  moduleData: ModuleTemplateData,
  packageName: String,
  className: String
) {
  val (_, _, _, _) = moduleData
  val project = projectInstance ?: return

  addAllKotlinDependencies(moduleData)
  addPackageName(packageName+"."+className.replaceFirstChar { it.lowercase() })

  val pfm = ProjectFileManager(project)
  if (pfm.init().not()) return

  createFragment(className = className, moduleData = moduleData)
    .save(pfm.dirOf(VIEW), PackageManager.viewPackageName, "${className}Fragment".asKt())

  createPresenter(className = className)
    .save(pfm.dirOf(PRESENTER), PackageManager.presenterPackageName, "${className}ViewModel".asKt())


  createInteractor(className = className)
    .save(pfm.dirOf(INTERACTOR), PackageManager.interactorPackageName, "${className}Interactor".asKt())

  createInteractorInterface(className = className)
    .save(pfm.dirOf(INTERACTOR), PackageManager.interactorPackageName, "${className}InteractorInterface".asKt())

  createInteractorDependenciesInterface(className = className)
    .save(pfm.dirOf(INTERACTOR), PackageManager.interactorPackageName, "${className}InteractorDependenciesInterface".asKt())

  createInteractorModel(className = className)
    .save(pfm.dirOf(MODEL), PackageManager.interactorModelPackageName, "${className}ItemInterface".asKt())

  createPresenterModel(className = className)
    .save(pfm.dirOf(MODEL), PackageManager.presenterModelPackageName, "${className}ItemInterface".asKt())
}