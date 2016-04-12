# android-ndk-audio
This Project is a open-sl exmample of using Android Studio, Gradle Experimental, NDK, SWIG.
Please see the references if there is a question.

## How to run
* install ndk : http://developer.android.com/ndk/downloads/index.html
* install swig : http://www.swig.org/download.html

```
$ git clone https://github.com/westside/android-ndk-audio.git
$ cd android-ndk-audio
$ ./gradlew runSwig   --> this creates jni wrapper class
```


## References
* Android SWIG example : https://github.com/sureshjoshi/android-ndk-swig-example
* Android NDK example : https://github.com/googlesamples/android-ndk
* OpenSL with NDK and SWIG : https://audioprograming.wordpress.com/2012/10/30/on-wrapping-android-ndk-code-with-swig/
* Android Gradle Experimental Plugin : http://tools.android.com/tech-docs/new-build-system/gradle-experimental
