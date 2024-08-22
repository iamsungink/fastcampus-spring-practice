plugins {
    id("java")
    id("war")
}

group = "com.fastcampus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    compileOnly("javax.servlet:javax.servlet-api:4.0.1")

    implementation("org.springframework:spring-webmvc:5.3.39")

    testImplementation("org.springframework:spring-test:5.3.39")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

val explodedDir = layout.buildDirectory.dir("libs/exploded").get().asFile

val explodedWar by tasks.register<Copy>("explodedWar") {
    into(explodedDir)
    with(tasks.war.get())
}
tasks.war {
    finalizedBy(explodedWar)
}