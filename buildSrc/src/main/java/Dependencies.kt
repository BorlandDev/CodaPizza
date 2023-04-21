object Dependencies {

    object Compose {
        private const val composeVersion = "1.5.0-alpha02"

        const val ui = "androidx.compose.ui:ui:$composeVersion"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val material = "androidx.compose.material:material:$composeVersion"
        const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
        const val foundation = "androidx.compose.foundation:foundation:$composeVersion"
        const val activity = "androidx.activity:activity-compose:1.7.0"
    }

    object Plugins {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinVersion = "org.jetbrains.kotlin.android"
        const val parcelable = "org.jetbrains.kotlin.plugin.parcelize"
    }
}