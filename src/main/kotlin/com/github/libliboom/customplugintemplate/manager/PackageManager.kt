package com.github.libliboom.customplugintemplate.manager

fun addPackageName(packageName: String) = PackageManager.setPackageName(packageName)

object PackageManager {

  var interactorPackageName = ""
  var presenterPackageName = ""
  var viewPackageName = ""
  var interactorModelPackageName = ""
  var presenterModelPackageName = ""

  fun setPackageName(packageName: String) {
    interactorPackageName = "${packageName}.businessLogic.${Path.INTERACTOR.name.lowercase()}"
    presenterPackageName = "${packageName}.userInterface.${Path.PRESENTER.name.lowercase()}"
    viewPackageName = "${packageName}.userInterface.${Path.VIEW.name.lowercase()}"
    interactorModelPackageName = "${packageName}.businessLogic.${Path.MODEL.name.lowercase()}"
    presenterModelPackageName = "${packageName}.userInterface.presenter.${Path.MODEL.name.lowercase()}"
  }

}