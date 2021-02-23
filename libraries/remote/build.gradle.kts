import Dependencies.Network
import Dependencies.Test
import ProjectLib.domain

plugins {
    kotlinLibrary
    kotlin(kotlinKapt)
}

dependencies {

    implementation(project(domain))
    implementAll(Network.components)

    testImplementation(Test.mockWebServer)

    kapt(Network.AnnotationProcessor.moshi)
}