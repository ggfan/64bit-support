#include <jni.h>
#include <string>

extern "C"  JNIEXPORT jlong JNICALL
Java_com_example_aar_1lib_SampleLib_productNative(JNIEnv *env, jobject instance, jint a,
                                                     jint b) {
    return ((jlong)a * (jlong)b);
}
