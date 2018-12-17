There are 2 ways to do that
First Way: Using Android Studio Menu (this is not my favourite)
==============================================================
1. File -> New -> New Module -> Import .jar/.aar and import your .aar.
1. application module settings, dependency > "+" > module > select the newly added lib module

or do it manually as:
```
In your project’s build.gradle (the one under ‘app’) add the following:
dependencies {
 compile project(‘:Name-of-the-Project’)
}
```

With this approach, every .aar file you add, will be visible in your project hierarchy (like the libraries you create and maintain in project).

Second Way: By Creating libs Folder
==================================
 1. Create ‘libs’ folder under src/main
 1. Copy your .aar file to src/main/libs
 1. Open ‘build.gradle’ file(the one under ‘app’) and add dependency compile(name:’my_library’, ext:’aar’
We now have an error message saying ‘Failed to resolve :my_library’. To fix this error open the top level ‘build.gradle’ file and add

flatDir { 
 dirs ‘src/main/libs’ 
}

