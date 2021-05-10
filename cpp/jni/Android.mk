# https://developer.android.com/ndk/guides/android_mk
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := helloworld
LOCAL_SRC_FILES := ../src/main.cpp
LOCAL_CFLAGS += -fPIE
# LOCAL_LDFLAGS += -fPIE -pie
LOCAL_LDFLAGS += -fPIE
# LOCAL_LDLIBS := -lz
# LOCAL_CPP_FEATURES := exceptions

include $(BUILD_SHARED_LIBRARY)