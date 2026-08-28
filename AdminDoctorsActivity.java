package com.SMC.smarthealthcare;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.SMC.smarthealthcare.models.Doctor;
import com.SMC.smarthealthcare.ui.adapters.DoctorsAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0015H\u0002J\u001c\u0010-\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u00100\u001a\u00020+H\u0002J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020+H\u0002J\b\u00103\u001a\u00020+H\u0002J\u0012\u00104\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020+H\u0014J\u0010\u00108\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0015H\u0002J\b\u00109\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020+H\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020\u0004H\u0002J\u0018\u0010=\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0019H\u0002J\b\u0010?\u001a\u00020+H\u0002J\u0010\u0010@\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/SMC/smarthealthcare/AdminDoctorsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adminHospitalId", "", "adminHospitalName", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "btnAddDoctor", "Landroid/widget/Button;", "btnBack", "btnNotifications", "btnRefresh", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "departmentId", "departmentName", "doctorsAdapter", "Lcom/SMC/smarthealthcare/ui/adapters/DoctorsAdapter;", "doctorsList", "", "Lcom/SMC/smarthealthcare/models/Doctor;", "emptyState", "Landroid/widget/LinearLayout;", "filterByDepartment", "", "filteredList", "progressBar", "Landroid/widget/ProgressBar;", "rvDoctors", "Landroidx/recyclerview/widget/RecyclerView;", "searchView", "Landroidx/appcompat/widget/SearchView;", "spinnerSpecialization", "Landroid/widget/Spinner;", "tvActiveDoctors", "Landroid/widget/TextView;", "tvEmptyMessage", "tvHospitalName", "tvInactiveDoctors", "tvNewDoctors", "tvTotalDoctors", "deleteDoctor", "", "doctor", "filterDoctors", "query", "specialization", "initializeViews", "loadAdminDetails", "loadDoctors", "loadSpecializations", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "performDelete", "setupListeners", "showContent", "showEmptyState", "message", "toggleDoctorStatus", "isActive", "updateStats", "viewDoctorDetails", "Companion", "app_debug"})
public final class AdminDoctorsActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.firestore.FirebaseFirestore db;
    private com.google.firebase.auth.FirebaseAuth auth;
    private androidx.recyclerview.widget.RecyclerView rvDoctors;
    private androidx.appcompat.widget.SearchView searchView;
    private android.widget.Spinner spinnerSpecialization;
    private android.widget.Button btnAddDoctor;
    private android.widget.Button btnBack;
    private android.widget.Button btnNotifications;
    private android.widget.TextView tvHospitalName;
    private android.widget.TextView tvTotalDoctors;
    private android.widget.TextView tvActiveDoctors;
    private android.widget.TextView tvInactiveDoctors;
    private android.widget.TextView tvNewDoctors;
    private android.widget.ProgressBar progressBar;
    private android.widget.LinearLayout emptyState;
    private android.widget.TextView tvEmptyMessage;
    private android.widget.Button btnRefresh;
    private com.SMC.smarthealthcare.ui.adapters.DoctorsAdapter doctorsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.SMC.smarthealthcare.models.Doctor> doctorsList = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.SMC.smarthealthcare.models.Doctor> filteredList = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String adminHospitalName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String adminHospitalId = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String departmentId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String departmentName;
    private boolean filterByDepartment = false;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AdminDoctorsActivity";
    @org.jetbrains.annotations.NotNull()
    public static final com.SMC.smarthealthcare.AdminDoctorsActivity.Companion Companion = null;
    
    public AdminDoctorsActivity() {
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
    
    private final void loadDoctors() {
    }
    
    private final void loadSpecializations() {
    }
    
    private final void updateStats() {
    }
    
    private final void filterDoctors(java.lang.String query, java.lang.String specialization) {
    }
    
    private final void toggleDoctorStatus(com.SMC.smarthealthcare.models.Doctor doctor, boolean isActive) {
    }
    
    private final void deleteDoctor(com.SMC.smarthealthcare.models.Doctor doctor) {
    }
    
    private final void performDelete(com.SMC.smarthealthcare.models.Doctor doctor) {
    }
    
    private final void viewDoctorDetails(com.SMC.smarthealthcare.models.Doctor doctor) {
    }
    
    private final void showEmptyState(java.lang.String message) {
    }
    
    private final void showContent() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/SMC/smarthealthcare/AdminDoctorsActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}