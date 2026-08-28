package com.SMC.smarthealthcare;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.SMC.smarthealthcare.PatientMedicalHistoryActivity;
import com.SMC.smarthealthcare.R;
import com.google.firebase.firestore.FirebaseFirestore;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0012\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020 H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020 2\u0006\u0010)\u001a\u00020&H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/SMC/smarthealthcare/AdminPatientDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnBack", "Landroid/widget/Button;", "btnBackToList", "btnToggleBlock", "btnViewHistory", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "patientId", "", "patientName", "progressBar", "Landroid/widget/ProgressBar;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "tvAddress", "Landroid/widget/TextView;", "tvBlockStatus", "tvBloodGroup", "tvCity", "tvEmail", "tvEmergencyContact", "tvGender", "tvHospital", "tvPatientId", "tvPatientName", "tvPhone", "tvRegisteredOn", "tvState", "initializeViews", "", "loadPatientDetails", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "setupClickListeners", "showBlockConfirmationDialog", "block", "togglePatientBlock", "updateBlockStatusUI", "isBlocked", "Companion", "app_debug"})
public final class AdminPatientDetailsActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.firestore.FirebaseFirestore db;
    private androidx.appcompat.widget.Toolbar toolbar;
    private android.widget.Button btnBack;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView tvPatientName;
    private android.widget.TextView tvPatientId;
    private android.widget.TextView tvEmail;
    private android.widget.TextView tvPhone;
    private android.widget.TextView tvGender;
    private android.widget.TextView tvBloodGroup;
    private android.widget.TextView tvAddress;
    private android.widget.TextView tvEmergencyContact;
    private android.widget.TextView tvHospital;
    private android.widget.TextView tvCity;
    private android.widget.TextView tvState;
    private android.widget.TextView tvRegisteredOn;
    private android.widget.TextView tvBlockStatus;
    private android.widget.Button btnViewHistory;
    private android.widget.Button btnToggleBlock;
    private android.widget.Button btnBackToList;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String patientId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String patientName = "";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AdminPatientDetails";
    @org.jetbrains.annotations.NotNull()
    public static final com.SMC.smarthealthcare.AdminPatientDetailsActivity.Companion Companion = null;
    
    public AdminPatientDetailsActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initializeViews() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void showBlockConfirmationDialog(boolean block) {
    }
    
    private final void loadPatientDetails() {
    }
    
    private final void updateBlockStatusUI(boolean isBlocked) {
    }
    
    private final void togglePatientBlock(boolean block) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/SMC/smarthealthcare/AdminPatientDetailsActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}