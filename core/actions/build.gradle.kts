import com.ivy.buildsrc.Hilt

apply<com.ivy.buildsrc.IvyPlugin>()

plugins {
    `android-library`
    `kotlin-android`
}

dependencies {
    Hilt()
    implementation(project(":common"))
    implementation(project(":temp-persistence"))
    implementation(project(":core:functions"))
    implementation(project(":core:exchange"))
    implementation(project(":sync:public"))
}