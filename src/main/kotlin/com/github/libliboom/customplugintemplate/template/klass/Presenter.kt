package com.github.libliboom.customplugintemplate.template.klass

import com.github.libliboom.customplugintemplate.manager.PackageManager

fun createPresenter(
    presenterPackageName: String = PackageManager.presenterPackageName,
    className: String
) = """
  package $presenterPackageName
  
  import androidx.lifecycle.ViewModel
  
  class ${className}ViewModel : ViewModel(){
  
  } 
""".trimIndent()

fun createPresenterModel(
    presenterModelPackageName: String = PackageManager.presenterModelPackageName,
    className: String
) = """
  package $presenterModelPackageName
  
  interface ${className}ViewItemInterface {
  
  }
""".trimIndent()