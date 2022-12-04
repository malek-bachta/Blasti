package tn.mbach.warnMe.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Ltn/mbach/warnMe/Adapter/ClubbAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltn/mbach/warnMe/Adapter/ClubbAdapter$ClubViewHolder;", "ClubList", "Ljava/util/ArrayList;", "Ltn/mbach/warnMe/Data/clubbInfo;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getClubList", "()Ljava/util/ArrayList;", "setClubList", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ClubViewHolder", "app_debug"})
public final class ClubbAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<tn.mbach.warnMe.Adapter.ClubbAdapter.ClubViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<tn.mbach.warnMe.Data.clubbInfo> ClubList;
    
    public ClubbAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<tn.mbach.warnMe.Data.clubbInfo> ClubList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<tn.mbach.warnMe.Data.clubbInfo> getClubList() {
        return null;
    }
    
    public final void setClubList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<tn.mbach.warnMe.Data.clubbInfo> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public tn.mbach.warnMe.Adapter.ClubbAdapter.ClubViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    tn.mbach.warnMe.Adapter.ClubbAdapter.ClubViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2 = {"Ltn/mbach/warnMe/Adapter/ClubbAdapter$ClubViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ClubDate", "Landroid/widget/TextView;", "getClubDate", "()Landroid/widget/TextView;", "ClubImg", "Landroid/widget/ImageView;", "getClubImg", "()Landroid/widget/ImageView;", "ClubLocation", "getClubLocation", "ClubTitle", "getClubTitle", "app_debug"})
    public static final class ClubViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView ClubImg = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView ClubLocation = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView ClubTitle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView ClubDate = null;
        
        public ClubViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getClubImg() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getClubLocation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getClubTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getClubDate() {
            return null;
        }
    }
}