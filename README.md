# Aon

一个简单的注解库

## DownLoad

项目根目录的build.gradle文件

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Module的build.gradle文件

```
dependencies {
    implementation 'com.github.YpwCode:Aon:1.1.0'
}
// 或者
dependencies {
    compile 'com.github.YpwCode:Aon:1.1.0'
}

```

## 使用方式

```
public class MainActivity extends AppCompatActivity {

    @FindView(R.id.tv)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 注解解析类绑定
        Aon.bind(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "haha", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```
