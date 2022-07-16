package com.github.libliboom.customplugintemplate.template

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

val cleanArchFragmentTemplate
    get() = template {
      name = "Clean Architecture Packages"
      description = "Create Packages for Clean Architecture"
      minApi = 23
      category = Category.Other
      formFactor = FormFactor.Mobile
      screens = listOf(WizardUiContext.MenuEntry)

      val packageNameParam = defaultPackageNameParameter
      val classNameParam = stringParameter {
        name = "Feature Name"
        default = "Feature"
        help = "Use the feature name for prefix"
        constraints = listOf(Constraint.NONEMPTY)
      }

      widgets(
        PackageNameWidget(packageNameParam),
        TextFieldWidget(classNameParam)
      )

      recipe = { data: TemplateData ->
        cleanArchFragmentTemplate(
          data as ModuleTemplateData,
          packageNameParam.value,
          classNameParam.value
        )
      }
    }