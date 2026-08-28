package com.SMC.smarthealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.SMC.smarthealthcare.ui.adapters.PatientsAdapter;
import com.SMC.smarthealthcare.models.Patient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010\'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\u0012\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0018\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020$H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u00101\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020$2\u0006\u00101\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/SMC/smarthealthcare/AdminPatientsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adminHospitalId", "", "adminHospitalName", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "btnBack", "Landroid/widget/Button;", "btnNotifications", "btnRefresh", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "emptyState", "Landroid/widget/LinearLayout;", "filteredList", "", "Lcom/SMC/smarthealthcare/models/Patient;", "patientsAdapter", "Lcom/SMC/smarthealthcare/ui/adapters/PatientsAdapter;", "patientsList", "progressBar", "Landroid/widget/ProgressBar;", "rvPatients", "Landroidx/recyclerview/widget/RecyclerView;", "searchView", "Landroidx/appcompat/widget/SearchView;", "tvActivePatients", "Landroid/widget/TextView;", "tvBlockedPatients", "tvEmptyMessage", "tvHospitalName", "tvNewPatients", "tvTotalPatients", "filterPatients", "", "query", "initializeViews", "loadAdminDetails", "loadPatients", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupListeners", "showContent", "showEmptyState", "message", "togglePatientBlock", "patient", "isBlocked", "", "updateStats", "viewPatientDetails", "viewPatientHistory", "Companion", "app_debug"})
public final class AdminPatientsActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.firestore.FirebaseFirestore db;
    private com.google.firebase.auth.FirebaseAuth auth;
    private androidx.recyclerview.widget.RecyclerView rvPatients;
    private androidx.appcompat.widget.SearchView searchView;
    private android.widget.Button btnBack;
    private android.widget.Button btnNotifications;
    private android.widget.TextView tvTotalPatients;
    private android.widget.TextView tvActivePatients;
    private android.widget.TextView tvBlockedPatients;
    private android.widget.TextView tvNewPatients;
    private android.widget.ProgressBar progressBar;
    private android.widget.LinearLayout emptyState;
    private android.widget.TextView tvHospitalName;
    private android.widget.TextView tvEmptyMessage;
    private android.widget.Button btnRefresh;
    private com.SMC.smarthealthcare.ui.adapters.PatientsAdapter patientsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.SMC.smarthealthcare.models.Patient> patientsList = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.SMC.smarthealthcare.models.Patient> filteredList = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String adminHospitalName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String adminHospitalId = "";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AdminPatientsActivity";
    @org.jetbrains.annotations.NotNull()
    public static final com.SMC.smarthealthcare.AdminPatientsActivity.Companion Companion = null;
    
    public AdminPatientsActivity() {
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
    
    private final void loadAdminDetails() {
    }
    
    private final void loadPatients() {
    }
    
    private final void updateStats() {
    }
    
    private final void filterPatients(java.lang.String query) {
    }
    
    private final void showEmptyState(java.lang.String message) {
    }
    
    private final void showContent() {
    }
    
    private final void togglePatientBlock(com.SMC.smarthealthcare.models.Patient patient, boolean isBlocked) {
    }
    
    private final void viewPatientHistory(com.SMC.smarthealthcare.models.Patient patient) {
    }
    
    private final void viewPatientDetails(com.SMC.smarthealthcare.models.Patient patient) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/SMC/smarthealthcare/AdminPatientsActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}