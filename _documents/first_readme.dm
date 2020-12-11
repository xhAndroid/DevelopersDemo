
★
●
￭

https://developer.android.google.cn/topic/libraries/architecture
一、核心主题->架构组件
★★★★★视图绑定
在模块中启用视图绑定之后，系统会为该模块中的每个 XML 布局文件生成一个绑定类。绑定类的实例包含对在相应布局中具有 ID 的所有视图的直接引用。

● 要在某个模块中启用视图绑定，请将 viewBinding 元素添加到其 build.gradle 文件中
android {
        ...
        viewBinding {
        // 注意只能在AS 3.6 或更高版本中使用
            enabled = true
        }
    }

● 如果您希望在生成绑定类时忽略某个布局文件，请将 tools:viewBindingIgnore="true" 属性添加到相应布局文件的根视图中。

示例，某个布局文件的名称 result_profile.xml：
    <LinearLayout ... >
        <TextView android:id="@+id/name" />
        <ImageView android:cropToPadding="true" />
        <Button android:id="@+id/button"
            android:background="@drawable/rounded_button" />
    </LinearLayout>

● 在 Activity 中使用视图绑定
1、调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Activity 使用。
2、通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。
3、将根视图传递到 setContentView()，使其成为屏幕上的活动视图。

    private ResultProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ResultProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

● 在 Fragment 中使用视图绑定
1、调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Fragment 使用。
2、通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。
3、从 onCreateView() 方法返回根视图，使其成为屏幕上的活动视图。

    private ResultProfileBinding binding;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = ResultProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

