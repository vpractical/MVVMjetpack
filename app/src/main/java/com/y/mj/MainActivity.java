package com.y.mj;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.y.mj.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<User> list = new ArrayList<>();

    static {
        list.add(new User("赛利亚",25,"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1911428589,1373321293&fm=26&gp=0.jpg"));
        list.add(new User("云幂",23,"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3231129193,917533735&fm=26&gp=0.jpg"));
        list.add(new User("莎兰",28,"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=653736840,2449474724&fm=26&gp=0.jpg"));
    }

    int index = 0;
    User user = new User();
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            User u = list.get(index++);
            user.setNick(u.getNick());
            user.setAge(u.getAge());
            user.setAvatar(u.getAvatar());
            if(index >= list.size()){
                index = 0;
            }
            handler.postDelayed(r,6 * 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        r.run();
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.setUser(user);

        mainBinding.btnSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(r);
                r.run();
            }
        });
    }

}
