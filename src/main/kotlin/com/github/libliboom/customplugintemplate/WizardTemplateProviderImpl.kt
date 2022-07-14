package com.github.libliboom.customplugintemplate

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.libliboom.customplugintemplate.template.cleanArchFragmentTemplate

class WizardTemplateProviderImpl : WizardTemplateProvider() {
  override fun getTemplates(): List<Template> = listOf(cleanArchFragmentTemplate)
}