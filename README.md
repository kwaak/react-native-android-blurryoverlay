# Blurry overlay for react-native android

[![npm](https://img.shields.io/npm/v/react-native-android-blurryoverlay.svg)](https://www.npmjs.com/package/react-native-android-blurryoverlay)

# This is very experimental

A react native android module to add a blurry overlay.

![Example](Examples/Example.gif?raw=true "Example")

## Setup

* install module

```bash
 npm i --save react-native-android-blurryoverlay
```

* `android/settings.gradle`

```gradle
...
include ':react-native-android-blurryoverlay'
project(':react-native-android-blurryoverlay').projectDir = new File(settingsDir, '../node_modules/react-native-android-blurryoverlay')
```

* `android/app/build.gradle`

```gradle
...
android {
    ...
    defaultConfig {
        ...        
        renderscriptTargetApi 23
        renderscriptSupportModeEnabled true
    }    
    ...
}
...
dependencies {
    ...
    compile project(':react-native-android-blurryoverlay')
}
```

* register module (in MainActivity.java)

```java
import com.kwaak.react.BlurryOverlayPackage;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {

  ......
  private static Activity mActivity = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mActivity = this;
    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new BlurryOverlayPackage(this))      // <------- add package, the 'this' is super important
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Usage

The Android root view will be 'screenshotted' and rendered blurry in the <BlurryOverlay> view.

```js
var BlurryOverlay = require('react-native-android-blurryoverlay');

<BlurryOverlay radius={5} sampling={6} color="#00FFFF00" style={[{flex: 1, position: "absolute", left: 0, top: 0, bottom: 0, right: 0 }]}  />

```
