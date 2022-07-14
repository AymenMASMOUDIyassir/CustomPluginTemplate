package com.github.libliboom.customplugintemplate.template.klass


import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateSimpleLayout
import com.github.libliboom.customplugintemplate.manager.PackageManager
import com.github.libliboom.customplugintemplate.template.utils.toSnakeCase
import com.github.libliboom.customplugintemplate.template.workaround.manifestTemplateXml
import java.io.File

fun RecipeExecutor.createFragment(
    packageName: String = PackageManager.viewPackageName,
    applicationPackageName: String = PackageManager.applicationPackageName,
    className: String,
    manifestOut: File,
    moduleData: ModuleTemplateData
): String {
    val fragmentClassName = "${className}Fragment"
    val layoutFileName = "fragment_${className}"
    generateSimpleLayout(moduleData, fragmentClassName, layoutFileName.toSnakeCase())
    return createFragment(packageName, applicationPackageName, className)
}

fun createFragment(
    packageName: String,
    applicationPackageName: String,
    className: String
) = """
  package $packageName
  
  import androidx.fragment.app.Fragment
  
  class ${className}Fragment : Fragment() {
        
  }
""".trimIndent()