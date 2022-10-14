# Recfy SDK

## Installation

root project gradle

```Gradle 
maven {
    name = "GitHubPackages"
    url = uri("https://maven.pkg.github.com/DevSoulDynamics/RECfy-SDK-Android")
    credentials {
         username props['GITHUB_username']
         password props['GITHUB_token']
    }
}
```
project gradle
```Gradle 
implementation "com.devsoul.recfy:sdk:VERSION"
```

## Usage
initialization
```kotlin
class MainActivity : AppCompatActivity() {
    private val uploaderSDK: RecfyUploaderSDK by lazy {
        RecfyUploaderSDK.create(this)
    }
}
```

Upload Media
```kotlin
uploaderSDK.uploadMedia(USER_EMAIL, EVENT_CODE, USER_GDPR)
```
