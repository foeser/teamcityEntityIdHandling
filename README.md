# Showcases Entity id handling in Kotlin DSL 
Showcases Entity id handling in Kotlin DSL in regard to certain lazy initialization on specific functions.

As you can see `BuildTypeA` of `ProjectB` has a trigger and snapshot dependency on `BuildTypeA` of `ProjectA`. The interesting fact
is that `ProjectB` get earlier initialized then `ProjectA` (see `settings.kts`) which lead to an `'kotlin.UninitializedPropertyAccessException: 
lateinit property projectABuildTypeAId has not been initialized'` exception once it gets referenced in example within the
description property of `ProjectB's BuildTypeA` (see `projectB/BuildTypeA.kt:10`).

Why this isn't the case for the referencing in the `dependency(...)` or `finishBuildTrigger(...)` function?

Of course in this simple example you could just change the order of the project's initialization. In bigger projects this might
not always possible as multiple projects need to cross-reference themselves. In that case you should work with some global
string based mapping for the `BuildType's` name/id and then use `RelativeId()` wherever you need to reference it.

