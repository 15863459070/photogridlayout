package cn.ljp.photogridlayout;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
 *@创建者       L_jp
 *@创建时间     2019/1/31 10:57.
 *@描述
 *
 *@更新者         $Author$
 *@更新时间         $Date$
 *@更新描述
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyVh> {

    private final Context mContext;
    private List<ItemBean> mItemBeans = new ArrayList<>();

    public ItemAdapter(Context context, List<ItemBean> itemBeans) {
        mItemBeans = itemBeans;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, null);
        return new MyVh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {
        ItemBean itemBean = mItemBeans.get(i);
        myVh.mTvContent.setText("我是内容我是内容我是内容我是内容");
        myVh.mIvUserIcon.setImageResource(R.mipmap.ic_launcher_round);
        myVh.mTvDate.setText(itemBean.getData());
        myVh.mTvName.setText(itemBean.getUserName());
        int spanCount = 3;
        List<String> photoList = itemBean.getPhotoList();
        int size = photoList.size();
        if (size == 1) {
            spanCount = 1;
        } else if (size == 2 || size == 4) {
            spanCount = 2;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, spanCount) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        myVh.mRecyclerView.addItemDecoration(new DividerGridItemDecoration(mContext));
        myVh.mRecyclerView.setLayoutManager(gridLayoutManager);

        myVh.mRecyclerView.setAdapter(new PhotoAdapter(photoList));
    }

    @Override
    public int getItemCount() {
        return mItemBeans.size();
    }

    public void setData(List<ItemBean> itemBeans) {
        this.mItemBeans = itemBeans;
        notifyDataSetChanged();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private final ImageView mIvUserIcon;
        private final TextView mTvName;
        private final TextView mTvDate;
        private final TextView mTvContent;
        private final RecyclerView mRecyclerView;

        public MyVh(@NonNull View itemView) {
            super(itemView);

            mIvUserIcon = itemView.findViewById(R.id.iv_user_icon);
            mTvName = itemView.findViewById(R.id.tv_user_name);
            mTvDate = itemView.findViewById(R.id.tv_date);
            mTvContent = itemView.findViewById(R.id.tv_content);
            mRecyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }
}
