package cn.ljp.photogridlayout;


import java.util.ArrayList;
import java.util.List;

/*
 *@创建者       L_jp
 *@创建时间     2019/1/31 11:00.
 *@描述
 *
 *@更新者         $Author$
 *@更新时间         $Date$
 *@更新描述
 */
public class ItemBean {

    private String userName = "用户名字";
    private String data = "2019-01-31 11:00";
    private List<String> photoList = new ArrayList<>();

    public ItemBean(int size) {
        for (int i = 0; i < size; i++) {
            photoList.add("");
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList;
    }
}
