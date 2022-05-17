package projectB

import commons.GlobalVariables
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.triggers.finishBuildTrigger

class BuildTypeB : BuildType ({
    name = "BuildType B"
    // uncommenting this would result in 'kotlin.UninitializedPropertyAccessException: lateinit property projectABuildTypeAId has not been initialized'
    //description = "I have a dependency on ${GlobalVariables.projectABuildTypeAId.value}"

    dependencies {
        dependency(GlobalVariables.projectABuildTypeAId) {
            snapshot {}
        }
    }

    triggers {
        finishBuildTrigger {
            buildType = GlobalVariables.projectABuildTypeAId.value
        }
    }
})