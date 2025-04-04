# CIPHER - A Caeser Encryption Application

## Description
An android application using Java, C++ and JNI, which converts a given text into its Caeser cipher equivalent. To learn more about about Caeser Cipher, [click here](https://www.geeksforgeeks.org/caesar-cipher-in-cryptography/).

## Features
- A Caeser cipher shift of 3 positions for alphabets (non-alphabetic characters remain the same)
- Input and Result text boxes
- Encrypt and Decrypt buttons
- Responsive and error free
- With a Logo
- Easy to install on local device (apk), using Android Studio

## Build
- Clone this repo on your local machine and open it with Android Studio.
```

git clone https://github.com/Survey845/Cipher.git

```
- Make sure you have an emulator on Android Studio, and run the code. It will automatically load up on the emulator by itself.
- Alternatively, you could build the APK from the "Build" drop-down menu, and then open the location of that file. This APK can be installed on a physical Android device.

## Framework/Languages
- Built using the Android Studio (Meerkat) software
- UI designed with Android XML
- Backend handling the UI written in Java
- Caese cipher logic written in C++
- Java Native Interface is used to link the C++ logic with the Java backend
- CMake is used to build the native-lib which holds the C++ logic.
