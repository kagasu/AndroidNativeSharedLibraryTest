#include <jni.h>

extern "C" {
JNIEXPORT jstring JNICALL Java_com_example_hellojni_MainActivity_helloworld(JNIEnv* env, jobject obj)
{
  return env->NewStringUTF("Hello World!");
}
}
