package tn.mbach.warnMe.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Ltn/mbach/warnMe/Adapter/showAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltn/mbach/warnMe/Adapter/showAdapter$ShowViewHolder;", "showList", "Ljava/util/ArrayList;", "Ltn/mbach/warnMe/Data/ShowInfo;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getShowList", "()Ljava/util/ArrayList;", "setShowList", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ShowViewHolder", "app_debug"})
public final class showAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<tn.mbach.warnMe.Adapter.showAdapter.ShowViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<tn.mbach.warnMe.Data.ShowInfo> showList;
    
    public showAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<tn.mbach.warnMe.Data.ShowInfo> showList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<tn.mbach.warnMe.Data.ShowInfo> getShowList() {
        return null;
    }
    
    public final void setShowList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<tn.mbach.warnMe.Data.ShowInfo> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public tn.mbach.warnMe.Adapter.showAdapter.ShowViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    tn.mbach.warnMe.Adapter.showAdapter.ShowViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2 = {"Ltn/mbach/warnMe/Adapter/showAdapter$ShowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ShowDate", "Landroid/widget/TextView;", "getShowDate", "()Landroid/widget/TextView;", "ShowImg", "Landroid/widget/ImageView;", "getShowImg", "()Landroid/widget/ImageView;", "ShowLocation", "getShowLocation", "ShowTitle", "getShowTitle", "app_debug"})
    public static final class ShowViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView ShowImg = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView ShowLocation = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView ShowTitle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView ShowDate = null;
        
        public ShowViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getShowImg() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getShowLocation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getShowTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getShowDate() {
            return null;
        }
    }
}