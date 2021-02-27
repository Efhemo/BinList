import Dependencies.Network
import Dependencies.Test
import ProjectLib.domain
import ProjectLib.testUtils

plugins {
    kotlinLibrary
    kotlin(kotlinKapt)
}

dependencies {

    implementation(project(testUtils))
    implementation(project(domain))
    implementAll(Network.components)

    testImplementation(Test.mockWebServer)

    kapt(Network.AnnotationProcessor.moshi)
}