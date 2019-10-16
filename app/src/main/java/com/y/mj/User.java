package com.y.mj;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class User extends BaseObservable {

    private String nick;
    private int age;
    private String avatar;

    public User(){}

    public User(String nick, int age, String avatar) {
        this.nick = nick;
        this.age = age;
        this.avatar = avatar;
    }

    @Bindable
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
        notifyPropertyChanged(BR.nick);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
    }

    @BindingAdapter("avatar")
    public static void getAvatar(ImageView iv,String url){
        Picasso.with(iv.getContext()).load(url).into(iv);
    }

    public void changeUser(View view){
        setAge(++age);
    }
}
