package com.SMC.smarthealthcare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.SMC.smarthealthcare.R;
import com.SMC.smarthealthcare.ui.adapters.UserQRAdapter;
import com.SMC.smarthealthcare.ui.adapters.UserQRItem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.SMC.smarthealthcare.utils.BitmapUtils;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010.\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020,H\u0002J\u0012\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\tH\u0002J\u0018\u00106\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020,2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u00105\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020,H\u0002J \u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0002J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u0004H\u0002J\u0010\u0010D\u001a\u00020,2\u0006\u00105\u001a\u00020\tH\u0002J\b\u0010E\u001a\u00020,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040*X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/SMC/smarthealthcare/AdminQRManagementActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adminHospitalId", "", "adminHospitalName", "adminHospitalNameTrimmed", "allQRItems", "", "Lcom/SMC/smarthealthcare/ui/adapters/UserQRItem;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "btnBack", "Landroid/widget/Button;", "btnRefresh", "btnRetry", "currentTab", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "displayItems", "doctorQRItems", "emptyState", "Landroid/widget/LinearLayout;", "patientQRItems", "progressBar", "Landroid/widget/ProgressBar;", "qrAdapter", "Lcom/SMC/smarthealthcare/ui/adapters/UserQRAdapter;", "radioAll", "Landroid/widget/RadioButton;", "radioDoctors", "radioPatients", "rvUserQRs", "Landroidx/recyclerview/widget/RecyclerView;", "searchView", "Landroidx/appcompat/widget/SearchView;", "tabLayout", "Landroid/widget/RadioGroup;", "tvHospitalName", "Landroid/widget/TextView;", "tvTotalQRs", "userRoles", "", "filterQRs", "", "query", "initializeViews", "loadAdminDetails", "loadAllQRCodes", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "performRegenerate", "item", "processDoctorDocument", "document", "Lcom/google/firebase/firestore/DocumentSnapshot;", "source", "processPatientDocument", "regenerateQR", "setupListeners", "shareQRCode", "bitmap", "Landroid/graphics/Bitmap;", "userName", "displayType", "showEmptyState", "message", "showQRCode", "updateDisplay", "Companion", "app_debug"})
public final class AdminQRManagementActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.firestore.FirebaseFirestore db;
    private com.google.firebase.auth.FirebaseAuth auth;
    private androidx.recyclerview.widget.RecyclerView rvUserQRs;
    private androidx.appcompat.widget.SearchView searchView;
    private android.widget.Button btnBack;
    private android.widget.Button btnRefresh;
    private android.widget.TextView tvTotalQRs;
    private android.widget.TextView tvHospitalName;
    private android.widget.ProgressBar progressBar;
    private android.widget.LinearLayout emptyState;
    private android.widget.RadioGroup tabLayout;
    private android.widget.RadioButton radioPatients;
    private android.widget.RadioButton radioDoctors;
    private android.widget.RadioButton radioAll;
    private android.widget.Button btnRetry;
    private com.SMC.smarthealthcare.ui.adapters.UserQRAdapter qrAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.SMC.smarthealthcare.ui.adapters.UserQRItem> allQRItems = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.SMC.smarthealthcare.ui.adapters.UserQRItem> patientQRItems = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.SMC.smarthealthcare.ui.adapters.UserQRItem> doctorQRItems = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.SMC.smarthealthcare.ui.adapters.UserQRItem> displayItems = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentTab = "all";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String adminHospitalName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String adminHospitalNameTrimmed = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String adminHospitalId = "";
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> userRoles = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AdminQRManagement";
    @org.jetbrains.annotations.NotNull()
    public static final com.SMC.smarthealthcare.AdminQRManagementActivity.Companion Companion = null;
    
    public AdminQRManagementActivity() {
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
    
    private final void loadAllQRCodes() {
    }
    
    private final void processPatientDocument(com.google.firebase.firestore.DocumentSnapshot document) {
    }
    
    private final void processDoctorDocument(com.google.firebase.firestore.DocumentSnapshot document, java.lang.String source) {
    }
    
    private final void updateDisplay() {
    }
    
    private final void filterQRs(java.lang.String query) {
    }
    
    private final void showEmptyState(java.lang.String message) {
    }
    
    private final void showQRCode(com.SMC.smarthealthcare.ui.adapters.UserQRItem item) {
    }
    
    private final void shareQRCode(android.graphics.Bitmap bitmap, java.lang.String userName, java.lang.String displayType) {
    }
    
    private final void regenerateQR(com.SMC.smarthealthcare.ui.adapters.UserQRItem item) {
    }
    
    private final void performRegenerate(com.SMC.smarthealthcare.ui.adapters.UserQRItem item) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/SMC/smarthealthcare/AdminQRManagementActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}