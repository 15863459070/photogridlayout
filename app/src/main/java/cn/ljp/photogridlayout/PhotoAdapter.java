package cn.ljp.photogridlayout;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/*
 *@创建者       L_jp
 *@创建时间     2019/1/31 11:09.
 *@描述
 *
 *@更新者         $Author$
 *@更新时间         $Date$
 *@更新描述
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyVh> {

    private List<String> mStringList;

    public PhotoAdapter(List<String> stringList) {
        mStringList = stringList;
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_item, null);
        return new MyVh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {
        myVh.mIvPhoto.setImageResource(R.mipmap.img_photo);
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    public class  MyVh extends RecyclerView.ViewHolder{

        private final ImageView mIvPhoto;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            mIvPhoto = itemView.findViewById(R.id.iv_photo);
        }
    }
}
