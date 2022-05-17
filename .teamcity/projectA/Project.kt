package projectA

import commons.GlobalVariables
import jetbrains.buildServer.configs.kotlin.Project

class ProjectA : Project({
    name = "Project A"

    val buildTypeA = ProjectABuildTypeA()
    buildType(buildTypeA)
    GlobalVariables.projectABuildTypeAId = buildTypeA.id!!
})