#include <string.h>
#include <jni.h>

jstring Java_cs474_ternaryCalc_MainActivity_invokeNativeFunction(JNIEnv* env, jobject javaThis) {
  return (*env)->NewStringUTF(env, "Hello from native code!");
}

JNIEXPORT jint JNICALL Java_cs474_ternaryCalc_MainActivity_decToTer(JNIEnv* env, jobject javaThis, jint input, jint length) {
  jint result = 0;
  jint x = 0;
  const char *nativeString = (*env)->GetStringUTFChars(env, input, 0);
  for (x = 0; x < length; x++) {
	  result += nativeString[x] * 3;
  }
  return result;
}

JNIEXPORT jint JNICALL Java_cs474_ternaryCalc_MainActivity_terToDec(JNIEnv* env, jobject javaThis, jint input, jint length) {
  jint result = 0;
  jint x = 0;
  const char *nativeString = (*env)->GetStringUTFChars(env, input, 0);
  for (x = 0; x < length; x++) {
	  result += nativeString[x] * 3;
  }
  return result;
}
