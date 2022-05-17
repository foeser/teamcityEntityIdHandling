package projectB

import commons.GlobalVariables
import jetbrains.buildServer.configs.kotlin.Project

class ProjectB : Project({
    name = "Project B"

    buildType(BuildTypeB())
})