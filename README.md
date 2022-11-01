# Recfy SDK

## Installation

add to root project gradle

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

## Example
Simple app to test the SDK, to run the example you should create a `github.properties` file:
```
username=GITHUB_username
token=GITHUB_token
```