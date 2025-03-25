#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_cipher_MainActivity_encrypt(JNIEnv *env, jobject obj, jstring text) {
    const char *input = env->GetStringUTFChars(text, nullptr);
    std::string result;

    for (int i = 0; input[i] != '\0'; i++) {
        char ch = input[i];
        if (isalpha(ch)) {
            char base = islower(ch) ? 'a' : 'A';
            ch = (ch - base + 3) % 26 + base;
        }
        result += ch;
    }

    env->ReleaseStringUTFChars(text, input);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_cipher_MainActivity_decrypt(JNIEnv *env, jobject obj, jstring text) {
    const char *input = env->GetStringUTFChars(text, nullptr);
    std::string result;

    for (int i = 0; input[i] != '\0'; i++) {
        char ch = input[i];
        if (isalpha(ch)) {
            char base = islower(ch) ? 'a' : 'A';
            ch = (ch - base - 3 + 26) % 26 + base;
        }
        result += ch;
    }

    env->ReleaseStringUTFChars(text, input);
    return env->NewStringUTF(result.c_str());
}