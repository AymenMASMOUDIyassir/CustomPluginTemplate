package com.github.libliboom.customplugintemplate.template.klass

import com.github.libliboom.customplugintemplate.manager.PackageManager

fun createPresenterModel(
    presenterModelPackageName: String = PackageManager.presenterModelPackageName,
    className: String
) = """
  package $presenterModelPackageName
  
  interface ${className}ViewItemInterface
""".trimIndent()