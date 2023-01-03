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
The upload process result can handle by overriding the activity result
```kotlin
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    when (requestCode) {
        RecfyUploaderSDK.ACTION_UPLOAD  -> {
            when (resultCode) {
                Activity.RESULT_OK -> "media uploaded."
                RecfyUploaderSDK.RESULT_UPLOAD_FAIL -> "media upload fail."
                RecfyUploaderSDK.RESULT_USER_CANCEL -> "media upload cancel by user"
            }
        }
    }
}
```

## Example
Simple app to test the SDK, to run the example you should create a `github.properties` file:
```
username=GITHUB_username
token=GITHUB_token
```