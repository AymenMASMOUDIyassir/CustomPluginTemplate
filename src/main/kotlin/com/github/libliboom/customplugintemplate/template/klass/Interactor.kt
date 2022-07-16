package com.github.libliboom.customplugintemplate.template.klass

import com.github.libliboom.customplugintemplate.manager.PackageManager

fun createInteractor(
    interactorPackageName: String = PackageManager.interactorPackageName,
    className: String
) = """
  package $interactorPackageName
  
  class ${className}Interactor{
  
  }
""".trimIndent()

fun createInteractorInterface(
    interactorPackageName: String = PackageManager.interactorPackageName,
    className: String
) = """
  package $interactorPackageName
  
  interface ${className}InteractorInterface{
  
  }
""".trimIndent()

fun createInteractorDependenciesInterface(
    interactorPackageName: String = PackageManager.interactorPackageName,
    className: String
) = """
  package $interactorPackageName
  
  interface ${className}InteractorDependenciesInterface{
  
  }
""".trimIndent()

fun createInteractorModel(
    interactorModelPackageName: String = PackageManager.interactorModelPackageName,
    className: String
) = """
  package $interactorModelPackageName
  
  interface ${className}ItemInterface{
  
  }
""".trimIndent()