package com.github.libliboom.customplugintemplate.template.klass

import com.github.libliboom.customplugintemplate.manager.PackageManager

fun createInteractorModel(
    interactorModelPackageName: String = PackageManager.interactorModelPackageName,
    className: String
) = """
  package $interactorModelPackageName
  
  interface ${className}ItemInterface{
  
  }
""".trimIndent()