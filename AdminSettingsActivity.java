package com.SMC.smarthealthcare;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\u001c\u0010!\u001a\u00020\u00192\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00190#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/SMC/smarthealthcare/AdminSettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnBack", "Landroid/widget/Button;", "btnResetSettings", "btnSaveSettings", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "etConsultationFee", "Landroid/widget/EditText;", "etEmergencyFee", "etHospitalId", "etHospitalName", "etMaxAppointments", "etWorkingHoursEnd", "etWorkingHoursStart", "spinnerWorkingDays", "Landroid/widget/Spinner;", "switchWeekendAppointments", "Landroid/widget/Switch;", "workingDaysList", "", "", "initializeViews", "", "loadSettings", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "resetToDefault", "saveSettings", "setupListeners", "showTimePicker", "onTimeSelected", "Lkotlin/Function1;", "app_debug"})
public final class AdminSettingsActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.firestore.FirebaseFirestore db;
    private android.widget.EditText etHospitalName;
    private android.widget.EditText etHospitalId;
    private android.widget.EditText etWorkingHoursStart;
    private android.widget.EditText etWorkingHoursEnd;
    private android.widget.EditText etMaxAppointments;
    private android.widget.EditText etConsultationFee;
    private android.widget.EditText etEmergencyFee;
    private android.widget.Switch switchWeekendAppointments;
    private android.widget.Spinner spinnerWorkingDays;
    private android.widget.Button btnSaveSettings;
    private android.widget.Button btnResetSettings;
    private android.widget.Button btnBack;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> workingDaysList = null;
    
    public AdminSettingsActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initializeViews() {
    }
    
    private final void setupListeners() {
    }
    
    private final void showTimePicker(kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTimeSelected) {
    }
    
    private final void loadSettings() {
    }
    
    private final void saveSettings() {
    }
    
    private final void resetToDefault() {
    }
}