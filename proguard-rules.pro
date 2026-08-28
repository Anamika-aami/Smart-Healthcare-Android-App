# Room
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *

# Firebase
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }

# Your packages
-keep class com.SMC.smarthealthcare.** { *; }

# Keep data classes
-keepclassmembers class * {
    public *** get*();
    public void set*(***);
}



# Keep annotations
-keepattributes *Annotation*

# Keep line numbers
-keepattributes SourceFile,LineNumberTable