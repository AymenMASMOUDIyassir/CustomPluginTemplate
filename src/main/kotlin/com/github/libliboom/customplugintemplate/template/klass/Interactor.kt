package com.github.libliboom.customplugintemplate.template.klass

import com.github.libliboom.customplugintemplate.manager.PackageManager

fun createInteractorInput(
    interactorPackageName: String = PackageManager.interactorPackageName,
    className: String
) = """
  package $interactorPackageName
  
  interface ${className}interactorInput{
  
  }
""".trimIndent()

fun createInteractorOutput(
    interactorPackageName: String = PackageManager.interactorPackageName,
    className: String
) = """
  package $interactorPackageName
  
  interface ${className}interactorOutput{
  
  }
""".trimIndent()