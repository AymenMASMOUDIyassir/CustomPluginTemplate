package com.github.libliboom.customplugintemplate.manager


fun addPackageName(packageName: String, applicationPackageName: String) =
  PackageManager.setPackageName(packageName, applicationPackageName)

object PackageManager {

  private var _packageName: String = ""
  val packageName by lazy { _packageName }

  private var _applicationPackageName: String = ""
  val applicationPackageName by lazy { _applicationPackageName }

  /*val presentationPackageName by lazy { toModulePackageName(PRESENTATION.name)}
  val datasourcePackageName by lazy { toModulePackageName("data.${DATASOURCE.name}")}
  val repositoryPackageName by lazy { toModulePackageName("data.${REPOSITORY.name}")}
  val domainPackageName by lazy { toModulePackageName(DOMAIN.name)}*/
  val interactorPackageName by lazy { toModulePackageName("${_packageName}.businessLogic.${Path.INTERACTOR.name.lowercase()}")}
  val presenterPackageName by lazy { toModulePackageName("${_packageName}.userInterface.${Path.PRESENTER.name.lowercase()}")}
  val viewPackageName by lazy { toModulePackageName("${_packageName}.userInterface.${Path.VIEW.name.lowercase()}")}
  val interactorModelPackageName by lazy { toModulePackageName("${_packageName}.businessLogic.${Path.MODEL.name.lowercase()}")}
  val presenterModelPackageName by lazy { toModulePackageName("${_packageName}.userInterface.presenter.${Path.MODEL.name.lowercase()}")}

  fun setPackageName(packageName: String, applicationPackageName: String) {
    this._packageName = packageName
    this._applicationPackageName = applicationPackageName
  }
//com.aymensoft.myapplication. businessLogic.INTERACTOR
  private fun toModulePackageName(moduleName: String): String {
    return moduleName
    /*return _packageName
      .replace("ui", "")
      .split(".").let {
        val pre = it.subList(0, it.lastIndex - 1)
        val mid = listOf(moduleName.toLowerCase())
        val last = it.last()
        (pre + mid ).joinToString(".")
      }*/
  }
}