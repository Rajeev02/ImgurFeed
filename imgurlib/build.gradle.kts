plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("kotlin-kapt")
  }

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}


dependencies {
    implementation(libs.retrofit)
    implementation(libs.moshi)
    kapt(libs.moshi.kotlin.codegen)
    testImplementation(libs.junit)
    implementation(libs.converter.moshi)
}