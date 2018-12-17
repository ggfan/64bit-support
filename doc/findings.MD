Obversations
============
| app | lib | config(app/aar | build | apk |RunTime|Note |
|-----|-----|----------------|-------|-----|-------|-----|
| src | src |default/default | Y     |  Y  | Y     |     |
| src | src |64bOnly/32bOnly | Y     | no64bitAarLib|crash| expected |
| src | bin |default/all     | Y     |  Y  | Y     |     |
| src | bin |default/32bOnly | Y     |no64bLib|crash|*|
| src | bin |64Bit/32Bit     | Y     |no64bLib|crash|**|
| src | bin |64Bit/64Bit     | Y     |only64BitLib|Y|expected|
| src | bin |64Bit/fake64Bit | Y     |only64BitLib|crash|***|

(*): Apk's 32BitLibs have all native libs (app+aar's), laucher sees there 64 bit app version and simply use it, even there is no 32 bit lib to support app! App does not fall back to 32 bit :-)    

(**): APK only has 64 bit lib directries, but no aar's native lib. Crash at runtime is expected.

(***): in case of illegal so file packed into aar's 64 bit directory, Apk will still pack it. If it is indeed a 32 bit lib from AAR, the error message will display it:
```
java.lang.UnsatisfiedLinkError: dlopen failed: "/data/app/com.example.gfan.com.example.bit64-Oq6HLVxfPpJnfnm0h-WAag==/lib/arm64/libaar_lib.so" is 32-bit instead of 64-bit
```
This is a very unlikely case.

Detailed Error Code
-----------------
```
Error code ("couldn's find "libaar_lib.so" )
  E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.gfan.com.example.bit64, PID: 22249
    java.lang.UnsatisfiedLinkError: dalvik.system.PathClassLoader[DexPathList[[zip file "/data/app/com.example.gfan.com.example.bit64-z-kIX49SRrZdjYvuSaH28A==/base.apk"],nativeLibraryDirectories=[/data/app/com.example.gfan.com.example.bit64-z-kIX49SRrZdjYvuSaH28A==/lib/arm64, /data/app/com.example.gfan.com.example.bit64-z-kIX49SRrZdjYvuSaH28A==/base.apk!/lib/arm64-v8a, /system/lib64]]] couldn't find "libaar_lib.so"
```

Interesting Findings:
--------------------
- Studio does not check for the illegal cases @ compile time ( run-time crash cases )
- Launcher does not fallback to 32 bit case when 64 bit package is incomplete(not knowing enough about native lib dependencies?)

